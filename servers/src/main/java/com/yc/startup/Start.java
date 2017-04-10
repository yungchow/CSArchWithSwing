package com.yc.startup;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.nio.charset.Charset;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.concurrent.Executors;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.prefixedstring.PrefixedStringCodecFactory;
import org.apache.mina.filter.executor.ExecutorFilter;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import com.yc.dao.impl.DealerEmpImp;
import com.yc.emp.IDealerEmp;
import com.yc.session.ServerSessionHandler;

public class Start {

	private static final int PORT = 9123;
	
	public static void main(String[] args) throws IOException {
		IoAcceptor acceptor = new NioSocketAcceptor();
		acceptor.getFilterChain().addLast("threadPool",new ExecutorFilter(Executors.newCachedThreadPool()));
		acceptor.getFilterChain().addLast("logger", new LoggingFilter());
		acceptor.getFilterChain().addLast("codec", new ProtocolCodecFilter(new PrefixedStringCodecFactory(Charset.forName("UTF-8"))));
		acceptor.setHandler(new ServerSessionHandler());
		//一次最多读取这么多字节，不足也返回
		acceptor.getSessionConfig().setReadBufferSize(2048);
		//设置空转时间
		acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 10);
		acceptor.bind(new InetSocketAddress(PORT));
		

		try {
			IDealerEmp de = new DealerEmpImp();
			LocateRegistry.createRegistry(8998);
			Naming.bind("rmi://localhost:8998/RHello", de);
		} catch (RemoteException e) {
			System.out.println(e);
			e.printStackTrace();
		} catch (AlreadyBoundException e){
			System.out.println(e);
			e.printStackTrace();
		} catch(MalformedURLException e){
			System.out.println(e);
			e.printStackTrace();
		}
	
	}

}
