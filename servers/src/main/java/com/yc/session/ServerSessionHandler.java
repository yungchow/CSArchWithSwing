package com.yc.session;

import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

import com.yc.dao.UserDao;
import com.yc.dao.impl.UserDaoImp;
import com.yc.domain.Message;
import com.yc.domain.User;
import com.yc.util.Constants;
import com.yc.util.JsonUtil;

public class ServerSessionHandler implements IoHandler {

	private UserDao userDao = new UserDaoImp();

	public void exceptionCaught(IoSession arg0, Throwable arg1)
			throws Exception {
		arg1.printStackTrace();
	}

	public void inputClosed(IoSession arg0) throws Exception {
		
	}

	public void messageReceived(IoSession session, Object message) throws Exception {
		String string = message.toString();
		System.out.println("接收到的消息："+string);
		dealMessage(session,message);
	}

	private void sendMsg(IoSession session, Message message) {
		if (null != session) {
			String msg = JsonUtil.transToJson(message);
			session.write(msg);
			System.out.println("服务端发送的消息：" + msg.getBytes().length + msg);
		}
	}
	
	private void dealMessage(IoSession session, Object message) {
		Message msg = JsonUtil.transToBean(message.toString());
		System.out.println("msgType"+msg.getType());
		if(Constants.LOGIN_MSG.equals(msg.getType())){
			Message backMsg = login(msg,session);
			backMsg.setPalindType(Constants.LOGIN_MSG);
			sendMsg(session,backMsg);
		}
	}

	private Message login(Message msg,IoSession session) {
		String content = msg.getContent();
		String msgStr[] = content.split(Constants.LEFT_SLASH);
		User user = userDao.getUserByName(msgStr[0]);
		if (null == user) {
			return new Message(Constants.PALIND_MSG, Constants.LOGIN_MSG, "该账号不存在！");
		}
		user = userDao.login(msgStr[0], msgStr[1]);
		if (null == user) {
			return new Message(Constants.PALIND_MSG, Constants.LOGIN_MSG, "账号或密码输入有误！");
		}
		return new Message(Constants.PALIND_MSG, user);
	}

	public void messageSent(IoSession arg0, Object arg1) throws Exception {
		System.out.println("发送消息:"+arg1.toString());
	}

	public void sessionClosed(IoSession session) throws Exception {
		System.out.println("IP:"+session.getRemoteAddress().toString()+"断开连接");
	}

	public void sessionCreated(IoSession session) throws Exception {
		System.out.println("IP:"+session.getRemoteAddress().toString());
	}

	public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
		System.out.println("IDLE:"+session.getIdleCount(status));
	}

	public void sessionOpened(IoSession arg0) throws Exception {
		
	}

}
