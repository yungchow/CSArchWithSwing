package com.yc.login;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.prefixedstring.PrefixedStringCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import com.yc.domain.Message;
import com.yc.session.ClientSessionHandler;
import com.yc.util.JsonUtil;

public class Client {
	
	private IoConnector connector;
	private ConnectFuture connectFuture;
	private IoSession session;
	private LoginDig login;
	private MainDig mainDig;
	
	public Client(){

		//用于TCP/IP连接
		connector = new NioSocketConnector();
		//增加日志过滤链
		connector.getFilterChain().addLast("logger", new LoggingFilter());
		//增加协议过滤链，用于转换二进制或特定的协议数据为消息对象
		connector.getFilterChain().addLast("codec", new ProtocolCodecFilter(new PrefixedStringCodecFactory(Charset.forName("UTF-8"))));
		
		connector.setHandler(new ClientSessionHandler(this));
		
		connectFuture = connector.connect(new InetSocketAddress("127.0.0.1",9123));
		
		connectFuture.awaitUninterruptibly();
		System.out.println("连接成功");
		session = connectFuture.getSession();
		
//		if(session != null){
//			if(session.isConnected()){
//				session.getCloseFuture().awaitUninterruptibly();
//			}
//			//Release resources
//			connector.dispose(true);
//		}
	}
	
	public void sendMsg(Message message) {
		String msg = JsonUtil.transToJson(message);
//		channel.writeAndFlush(ByteBufAllocator.DEFAULT
//				.buffer().writeBytes(msg.getBytes()))
//				.addListener(new ClientListener());
		session.write(msg);
		System.out.println("客户端发送的消息：" + msg.getBytes().length + msg);
	} 
	
	public void setLogin(LoginDig login){
		this.login = login;
	}
	
	public LoginDig getLogin(){
		return login != null?login:null;
	}
	
	public void setMainDig(MainDig mainDig){
		this.mainDig = mainDig;
	}
	
	public MainDig getMainDig(){
		return mainDig != null ? mainDig : null;
	}
}
