package com.tcp.server.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.tcp.server.models.DateTime;
import com.tcp.server.models.MessageDateTime;
import com.tcp.server.models.MessageText;
import com.tcp.server.models.MessageUser;
import com.tcp.server.models.User;

/**
 * Classe que contém as consultas SQL realizadas pelo servidor
 * @author Alex Juno Bócoli
 *
 */
public class Sql {
    // Nome do driver JDBC e URL do banco de dados
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:mem:testdb";

    // Credenciais do banco de dados
    static final String USER = "sa";
    static final String PASS = "123456";
    
	private Connection conn;
	private Statement st;
	
	/**
	 * Insere uma mensagem de texto na tabela MESSAGETEXT
	 * @param txtMsg a mensagem a ser inserida
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
    public void insertMessageText(MessageText txtMsg) throws SQLException, ClassNotFoundException {
    	Class.forName(JDBC_DRIVER);
    	conn = DriverManager.getConnection(DB_URL, USER, PASS);
    	st = conn.createStatement();
    	
    	String sql = "INSERT INTO MESSAGETEXT (INIT, BYTES, FRAME, DATA, REGISTRATION_DATE, CRC, END) "
    		+ "VALUES (" + txtMsg.getInit() + "," + txtMsg.getBytes() + "," + txtMsg.getFrame() + ",'" + txtMsg.getData() + "','" 
    			+ txtMsg.getDateTime() + "'," + txtMsg.getCrc() + "," + txtMsg.getEnd() + ")";
    	
    	st.executeUpdate(sql);
    }
    
    /**
     * Insere um usuário na tabela USER
     * @param user o usuário a ser inserido
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void insertUser(User user) throws ClassNotFoundException, SQLException {
    	Class.forName(JDBC_DRIVER);
    	conn = DriverManager.getConnection(DB_URL, USER, PASS);
    	
    	st = conn.createStatement();
    	
    	String sql = "INSERT INTO USER (AGE, WEIGHT, HEIGHT, NAME, NAME_SIZE) "
    		+ "VALUES (" + user.getAge() + "," + user.getWeight() + "," + user.getHeight() + ",'"
    			+ user.getName() + "'," + user.getNameSize() + ")";
    	
    	st.executeUpdate(sql);
    }
    
    /**
     * Insere uma mensagem de usuário na tabela MESSAGEUSER
     * @param userMsg a mensagem a ser inserida
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void insertMessageUser(MessageUser userMsg) throws ClassNotFoundException, SQLException {
    	Class.forName(JDBC_DRIVER);
    	conn = DriverManager.getConnection(DB_URL, USER, PASS);
    	
    	String sql = "INSERT INTO MESSAGEUSER (INIT, BYTES, FRAME, DATA, CRC, END) "
    		+ "VALUES (?, ?, ?, ?, ?, ?)";
    	
    	PreparedStatement st = conn.prepareStatement(sql);
    	st.setObject(1, userMsg.getInit());
    	st.setObject(2, userMsg.getBytes());
    	st.setObject(3, userMsg.getFrame());
    	st.setObject(4, userMsg.getData());
    	st.setObject(5, userMsg.getCrc());
    	st.setObject(6, userMsg.getEnd());
    	st.execute();
    }
    
    /**
     * Consulta um fuso horário na tabela TIMEZONE
     * @param timezone o fuso horário a ser consultado
     * @return os dados do fuso horário consultado
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public ResultSet selectTimezone(String timezone) throws ClassNotFoundException, SQLException {
    	Class.forName(JDBC_DRIVER);
    	conn = DriverManager.getConnection(DB_URL, USER, PASS);
    	
    	String sql = "SELECT * FROM TIMEZONE WHERE LOCATION = ?";
    	
    	PreparedStatement st = conn.prepareStatement(sql);
    	st.setObject(1, timezone);
    	ResultSet rs = st.executeQuery();
    	
    	return rs;
    }
    
    /**
     * Insere uma data e hora na tabela DATETIME
     * @param dateTime a data e hora a serem inseridas
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void insertDateTime(DateTime dateTime) throws ClassNotFoundException, SQLException {
    	Class.forName(JDBC_DRIVER);
    	conn = DriverManager.getConnection(DB_URL, USER, PASS);
    	
    	String sql = "INSERT INTO DATETIME (DAY, MONTH, YEAR, HOUR, MINUTE, SECOND) "
        		+ "VALUES (?, ?, ?, ?, ?, ?)";
        	
    	PreparedStatement st = conn.prepareStatement(sql);
    	st.setObject(1, dateTime.getDay());
    	st.setObject(2, dateTime.getMonth());
    	st.setObject(3, dateTime.getYear());
    	st.setObject(4, dateTime.getHour());
    	st.setObject(5, dateTime.getMinute());
    	st.setObject(6, dateTime.getSecond());
    	st.execute();
    }
    
    /**
     * Insere uma mensagem de data e hora na tabela MESSAGEDATETIME
     * @param dtMsg a mensagem a ser inserida
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void insertMessageDateTime(MessageDateTime dtMsg) throws ClassNotFoundException, SQLException {
    	Class.forName(JDBC_DRIVER);
    	conn = DriverManager.getConnection(DB_URL, USER, PASS);
    	
    	String sql = "INSERT INTO MESSAGEDATETIME (INIT, BYTES, FRAME, DATA, CRC, END) "
    		+ "VALUES (?, ?, ?, ?, ?, ?)";
    	
    	PreparedStatement st = conn.prepareStatement(sql);
    	st.setObject(1, dtMsg.getInit());
    	st.setObject(2, dtMsg.getBytes());
    	st.setObject(3, dtMsg.getFrame());
    	st.setObject(4, dtMsg.getData());
    	st.setObject(5, dtMsg.getCrc());
    	st.setObject(6, dtMsg.getEnd());
    	st.execute();
    }
}
