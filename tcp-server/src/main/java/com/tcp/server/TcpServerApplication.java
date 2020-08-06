package com.tcp.server;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import com.tcp.server.controllers.Server;

@SpringBootApplication
//@EntityScan("com.tcp.server.models")
public class TcpServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TcpServerApplication.class, args);
		
		//Timezone t1 = new Timezone("Brazil", "America/Araguaina", 3, 0, "-");
		
        Server server = new Server();
        
        try {
			server.startServer(6666);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
