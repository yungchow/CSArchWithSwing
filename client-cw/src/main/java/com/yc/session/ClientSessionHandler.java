package com.yc.session;


import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

import com.yc.domain.Message;
import com.yc.login.Client;
import com.yc.login.MainDig;
import com.yc.util.Constants;
import com.yc.util.ContainerUtil;
import com.yc.util.JsonUtil;

public class ClientSessionHandler implements IoHandler{

	private Client client;
	
	public ClientSessionHandler(Client client){
		this.client = client;
	}

	@Override
	public void exceptionCaught(IoSession arg0, Throwable arg1)
			throws Exception {
		// TODO Auto-generated method stub
		arg1.printStackTrace();
	}

	@Override
	public void inputClosed(IoSession arg0) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		String msgStr = message.toString();
		System.err.println("接收的消息：" + msgStr.getBytes().length + msgStr);
		Message msg = JsonUtil.transToBean(msgStr);
		// 不同类型消息不同处理
		// 回文
		if (null != msg && Constants.PALIND_MSG.equals(msg.getType())) {
			if (Constants.LOGIN_MSG.equals(msg.getPalindType())) {
				if(null != msg.getUser()){
					client.getLogin().dispose();
					MainDig inst = MainDig.getInstance(client);
					client.setMainDig(inst);
				}else{
					ContainerUtil.showErrorMessage(client.getLogin(),msg.getContent());
				}
			}
		}
	}

	@Override
	public void messageSent(IoSession arg0, Object message) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("client发送信息:"+message.toString());
	}

	@Override
	public void sessionClosed(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("client与"+session.getRemoteAddress().toString()+"断开连接");
	}

	@Override
	public void sessionCreated(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("client与"+session.getRemoteAddress().toString()+"建立连接");
	}

	@Override
	public void sessionIdle(IoSession session, IdleStatus idle) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("IDLE "+session.getIdleCount(idle));
	}

	@Override
	public void sessionOpened(IoSession arg0) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("打开连接");
	}



}
