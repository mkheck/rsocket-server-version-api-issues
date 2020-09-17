package com.thehecklers.rsocketserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.netty.DisposableServer;
import reactor.netty.tcp.TcpServer;

@SpringBootApplication
public class RsocketServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RsocketServerApplication.class, args);
//
//		DisposableServer server =
//				TcpServer.create()
//						.wiretap(true)
//						.bindNow();
//
//		server.onDispose()
//				.block();
	}

}
