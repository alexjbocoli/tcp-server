package com.tcp.server.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
//@PrimaryKeyJoinColumn(name = "idMsgText")
@Table(name = "messagetext")
public class MessageText extends Message implements Serializable {
	private static final long serialVersionUID = 1L;
	
    @Column(name = "data")
	private String data;
    @Column(name = "registration_date")
    private String dateTime;
	
	public MessageText(int init, int bytes, int frame, int crc, int end, String data, String dateTime) {
		super(init, bytes, frame, crc, end);
		this.data = data;
		this.dateTime = dateTime;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
}
