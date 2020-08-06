package com.tcp.server.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
//@PrimaryKeyJoinColumn(name = "idMsgUser")
@Table(name = "messageuser")
public class MessageUser extends Message implements Serializable{
	private static final long serialVersionUID = 1L;
	
    @Column(name = "data")
	private User data;
	
	public MessageUser(int init, int bytes, int frame, int crc, int end, User data) {
		super(init, bytes, frame, crc, end);
		this.data = data;
	}

	public User getData() {
		return data;
	}

	public void setData(User data) {
		this.data = data;
	}
}
