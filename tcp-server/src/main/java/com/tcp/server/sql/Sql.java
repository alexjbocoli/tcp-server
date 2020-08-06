package com.tcp.server.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.tcp.server.models.DateTime;
import com.tcp.server.models.MessageDateTime;
import com.tcp.server.models.MessageText;
import com.tcp.server.models.MessageUser;
import com.tcp.server.models.User;

public class Sql {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:mem:testdb";

    //  Database credentials
    static final String USER = "sa";
    static final String PASS = "123456";
    
	private Connection conn;
	private Statement st;
	
    public void insertMessageText(MessageText txtMsg) throws SQLException, ClassNotFoundException {
    	Class.forName(JDBC_DRIVER);
    	conn = DriverManager.getConnection(DB_URL, USER, PASS);
    	st = conn.createStatement();
    	
    	String sql = "INSERT INTO MESSAGETEXT (INIT, BYTES, FRAME, DATA, REGISTRATION_DATE, CRC, END) "
    		+ "VALUES (" + txtMsg.getInit() + "," + txtMsg.getBytes() + "," + txtMsg.getFrame() + ",'" + txtMsg.getData() + "','" 
    			+ txtMsg.getDateTime() + "'," + txtMsg.getCrc() + "," + txtMsg.getEnd() + ")";
    	
    	st.executeUpdate(sql);
    }
    
    public void insertUser(User user) throws ClassNotFoundException, SQLException {
    	Class.forName(JDBC_DRIVER);
    	conn = DriverManager.getConnection(DB_URL, USER, PASS);
    	
    	/**String sql = "INSERT INTO USER (AGE, WEIGHT, HEIGHT, NAME, NAME_SIZE) VALUES (?, ?, ?, ?, ?)";
    	
    	PreparedStatement st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    	st.setObject(1, user.getAge());
    	st.setObject(2, user.getWeight());
    	st.setObject(3, user.getHeight());
    	st.setObject(4, user.getName());
    	st.setObject(5, user.getNameSize());
    	st.execute();
    	
    	ResultSet rs = st.getGeneratedKeys();
    	rs.next();
    	
    	return rs.getLong(1);**/
    	
    	st = conn.createStatement();
    	
    	String sql = "INSERT INTO USER (AGE, WEIGHT, HEIGHT, NAME, NAME_SIZE) "
    		+ "VALUES (" + user.getAge() + "," + user.getWeight() + "," + user.getHeight() + ",'"
    			+ user.getName() + "'," + user.getNameSize() + ")";
    	
    	st.executeUpdate(sql);
    }
    
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
    
    public ResultSet selectTimezone(String timezone) throws ClassNotFoundException, SQLException {
    	Class.forName(JDBC_DRIVER);
    	conn = DriverManager.getConnection(DB_URL, USER, PASS);
    	
    	String sql = "SELECT * FROM TIMEZONE WHERE LOCATION = ?";
    	
    	PreparedStatement st = conn.prepareStatement(sql);
    	st.setObject(1, timezone);
    	ResultSet rs = st.executeQuery();
    	
    	return rs;
    }
    
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
