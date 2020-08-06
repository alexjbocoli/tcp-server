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
//@PrimaryKeyJoinColumn(name = "idMsgDateTime")
@Table(name = "messagedatetime")
public class MessageDateTime extends Message implements Serializable {
	private static final long serialVersionUID = 1L;
	
    @Column(name = "data")
	private DateTime data;
	
	public MessageDateTime(int init, int bytes, int frame, int crc, int end, DateTime data) {
		super(init, bytes, frame, crc, end);
		this.data = data;
	}

	public DateTime getData() {
		return data;
	}

	public void setData(DateTime data) {
		this.data = data;
	}
}
