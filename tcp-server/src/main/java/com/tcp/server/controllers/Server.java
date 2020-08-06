package com.tcp.server.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;

import javax.xml.bind.DatatypeConverter;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import com.tcp.server.utils.CRC8;
import com.tcp.server.models.DateTime;
import com.tcp.server.models.Message;
import com.tcp.server.models.MessageDateTime;
import com.tcp.server.models.MessageText;
import com.tcp.server.models.MessageUser;
import com.tcp.server.models.User;
import com.tcp.server.sql.Sql;

@EntityScan("com.tcp.server.models")
public class Server {
	private ServerSocket serverSocket;
	
    public void startServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        while (true) {
            new ClientHandler(serverSocket.accept()).start();
        }
    }
 
    public void stopServer() throws IOException {
        serverSocket.close();
    }
 
    private static class ClientHandler extends Thread {
        private Socket clientSocket;
        //private ObjectOutputStream out;
        //private ObjectInputStream in;
        private PrintWriter out;
        private BufferedReader in;
 
        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }
 
        public void run() {
        	try {
                //out = new ObjectOutputStream(clientSocket.getOutputStream());
                //in = new ObjectInputStream(clientSocket.getInputStream());
        		out = new PrintWriter(clientSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                
                // Protocolo recebido
                System.out.println("Mensagem recebida!");
                String protocol = in.readLine();
                
                // Conversão do protocolo de string para array
        		ArrayList<String> msgHexArray = new ArrayList<String>();
        		for (String hex: protocol.replaceAll( "..(?!$)", "$0," ).split( "," ) ) {
        			msgHexArray.add(hex);
        		}
        		System.out.println(msgHexArray);
        		
        		// Construção da string para cálculo do CRC (bytes, frame, data, crc)
        		String crcCalc = "";
        		for (int i = 1; i <= msgHexArray.size() - 2; i++) {
        			crcCalc = crcCalc + msgHexArray.get(i);
        		}
        		
        		// Conversão em array de bytes para cálculo do CRC
        		byte[] inputCrc = DatatypeConverter.parseHexBinary(crcCalc);
        		
        		// Cálculo do CRC
        		CRC8 crc8 = new CRC8();
        		crc8.reset();
        		crc8.update(inputCrc);
        		String hexCrc = Integer.toHexString((int) crc8.getValue());
        		System.out.println("Hex CRC: " + hexCrc);
        		
        		// Se o CRC recalculado = 0, insere no banco e envia ACK ao cliente
        		if (hexCrc.equals("0")) {       			
        			// Se for mensagem de texto
        			if (msgHexArray.get(2).equals("A1")) {
        				System.out.println("Mensagem sem erros! Enviando ACK...");
        				
        				// Conversão
            			int init = Integer.parseInt(msgHexArray.get(0), 16);
            			int bytes = Integer.parseInt(msgHexArray.get(1), 16);
            			int frame = Integer.parseInt(msgHexArray.get(2), 16);
            			int crc = Integer.parseInt(msgHexArray.get(msgHexArray.size() - 2), 16);
            			int end = Integer.parseInt(msgHexArray.get(msgHexArray.size() - 1), 16);
            			
            			StringBuilder sb = new StringBuilder();
            			for (int i = 3; i <= msgHexArray.size() - 3; i++) {
            				sb.append(msgHexArray.get(i));
            			}
            			String dataHex = sb.toString();
            			
            			StringBuilder sb2 = new StringBuilder();
            			for (int i = 0; i < dataHex.length(); i+=2) {
            			    String str = dataHex.substring(i, i+2);
            			    sb2.append((char)Integer.parseInt(str, 16));
            			}
            			String dataAscii = sb2.toString();
            			
            			Date dateTime = new Date();
            			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            			
            			// Criação do objeto MessageText e inserção no banco de dados
            			MessageText txtMsg = new MessageText(init, bytes, frame, crc, end, dataAscii, dateFormat.format(dateTime));
            			Sql sql = new Sql();
            			sql.insertMessageText(txtMsg);
            			        			
            			// Envio da resposta           			
    	        		String ack = "0A05A0280D";
    	        		out.println(ack);
        			}
        			else
    				// Se for informações de usuário
            		if (msgHexArray.get(2).equals("A2")) {
            			System.out.println("Mensagem sem erros! Enviando ACK...");
            			
            			// Conversão
            			int init = Integer.parseInt(msgHexArray.get(0), 16);
            			int bytes = Integer.parseInt(msgHexArray.get(1), 16);
            			int frame = Integer.parseInt(msgHexArray.get(2), 16);
            			int crc = Integer.parseInt(msgHexArray.get(msgHexArray.size() - 2), 16);
            			int end = Integer.parseInt(msgHexArray.get(msgHexArray.size() - 1), 16);
            			
            			ArrayList<String> data = new ArrayList<String>();
            			for (int i = 3; i <= msgHexArray.size() - 3; i++) {
            				data.add(msgHexArray.get(i));
            			}
            			
            			int age = Integer.parseInt(data.get(0), 16);
            			int weight = Integer.parseInt(data.get(1), 16);
            			int height = Integer.parseInt(data.get(2), 16);
            			int nameSize = Integer.parseInt(data.get(3), 16);
            			
            			StringBuilder sb = new StringBuilder();
            			for (int i = 4; i <= data.size() - 1; i++) {
            				sb.append(data.get(i));
            			}
            			String dataHex = sb.toString();
            			
            			StringBuilder sb2 = new StringBuilder();
            			for (int i = 0; i < dataHex.length(); i+=2) {
            			    String str = dataHex.substring(i, i+2);
            			    sb2.append((char)Integer.parseInt(str, 16));
            			}
            			String dataAscii = sb2.toString();
            			
            			// Criação do objeto User e MessageUser e inserção no banco de dados
            			Sql sql = new Sql();
            			
            			User user = new User(age, weight, height, nameSize, dataAscii);
            			sql.insertUser(user);
            			
            			MessageUser userMsg = new MessageUser(init, bytes, frame, crc, end, user);
            			sql.insertMessageUser(userMsg);
            			
            			// Envio da resposta           			
    	        		String ack = "0A05A0280D";
    	        		out.println(ack);
            		}
        			else
    				// Se for solicitação de data e hora
            		if (msgHexArray.get(2).equals("A3")) {
            			System.out.println("Mensagem sem erros! Enviando data e hora...");
            			
            			// Extrai o fuso horário requisitado do protocolo recebido
            			StringBuilder sb = new StringBuilder();
            			for (int i = 3; i <= msgHexArray.size() - 3; i++) {
            				sb.append(msgHexArray.get(i));
            			}
            			String dataHex = sb.toString();
            			
            			StringBuilder sb2 = new StringBuilder();
            			for (int i = 0; i < dataHex.length(); i+=2) {
            			    String str = dataHex.substring(i, i+2);
            			    sb2.append((char)Integer.parseInt(str, 16));
            			}
            			String dataAscii = sb2.toString();
            			//System.out.println(dataAscii);
            			
            			// Consulta na tabela TIMEZONE pelo fuso horário requisitado
            			Sql sql = new Sql();
            			ResultSet rs = sql.selectTimezone(dataAscii);
            			rs.next();	
            			int hour = rs.getInt(4);
            			int minute = rs.getInt(5);
            			String balance = rs.getString(6);
            			
            			// Data e hora em Greenwich
            			ZonedDateTime utc = ZonedDateTime.now(ZoneOffset.UTC);
            			ZonedDateTime reqTime;
            			if (balance.equals("-")) {           			
            				reqTime = ZonedDateTime.now(ZoneOffset.ofHoursMinutes(-hour, -minute));
            			}
            			else {
            				reqTime = ZonedDateTime.now(ZoneOffset.ofHoursMinutes(+hour, +minute));
            			}
            			
            			// Preparação da mensagem
            			String dayHex = Integer.toHexString(reqTime.getDayOfMonth());
            			if (dayHex.length() == 1) dayHex = "0" + dayHex;
            			String monthHex = Integer.toHexString(reqTime.getMonthValue());
            			if (monthHex.length() == 1) monthHex = "0" + monthHex;
            			String yearHex = Integer.toHexString(reqTime.getYear() - 2000);
            			if (yearHex.length() == 1) yearHex = "0" + yearHex;
            			String hourHex = Integer.toHexString(reqTime.getHour());
            			if (hourHex.length() == 1) hourHex = "0" + hourHex;
            			String minuteHex = Integer.toHexString(reqTime.getMinute());
            			if (minuteHex.length() == 1) minuteHex = "0" + minuteHex;
            			String secondHex = Integer.toHexString(reqTime.getSecond());
            			if (secondHex.length() == 1) secondHex = "0" + secondHex;
            			String dateHex = dayHex + monthHex + yearHex + hourHex + minuteHex + secondHex;
            			
            			// Construção da string para cálculo do CRC (bytes, frame, data)
            			crcCalc = "0B" + "A3" + dateHex;
            			
            			// Conversão em array de bytes para cálculo do CRC
            			inputCrc = DatatypeConverter.parseHexBinary(crcCalc);
            			
            			// Cálculo do CRC
            			crc8.reset();
            			crc8.update(inputCrc);
            			hexCrc = Integer.toHexString((int) crc8.getValue());
            			System.out.println("Hex CRC: " + hexCrc);
            			
            			// Criação do objeto DateTime e MessageDateTime e inserção no banco de dados
            			DateTime dateTime = new DateTime(reqTime.getDayOfMonth(), reqTime.getMonthValue(), 
                			reqTime.getYear() - 2000, reqTime.getHour(), reqTime.getMinute(), reqTime.getSecond());
                		sql.insertDateTime(dateTime);
                			
                		MessageDateTime dtMsg = new MessageDateTime(10, 11, 163, (int) crc8.getValue(), 13, dateTime);
                		sql.insertMessageDateTime(dtMsg);
            			
            			// Envio da resposta
            			protocol = "0A0BA3" + dateHex + hexCrc + "0D"; 
            			out.println(protocol);
            		}
        		}                
        			 
	            in.close();
	            out.close();
	            clientSocket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
        }
    }
}
