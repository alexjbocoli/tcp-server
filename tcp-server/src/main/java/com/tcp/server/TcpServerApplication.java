package com.tcp.server;

import java.io.IOException;
import java.util.Scanner;

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
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Informe a porta do servidor: ");
		int port = input.nextInt();
		System.out.println("Servidor iniciado na porta " + port + ".");
		
        Server server = new Server();
        
        try {
			server.startServer(port);
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        input.close();
    }

}
