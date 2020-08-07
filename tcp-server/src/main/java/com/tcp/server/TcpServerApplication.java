package com.tcp.server;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tcp.server.controllers.Server;

/**
 * Classe principal do servidor
 * @author Alex Juno Bócoli
 *
 */
@SpringBootApplication
public class TcpServerApplication {

	/**
	 * Método principal
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(TcpServerApplication.class, args);
		
        Server server = new Server();
        
        try {
			server.startServer(6666);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
