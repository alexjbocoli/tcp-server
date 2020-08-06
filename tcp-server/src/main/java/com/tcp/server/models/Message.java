package com.tcp.server.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

//@Entity
//@Inheritance(strategy = InheritanceType.JOINED)
//@Table(name = "message")
@MappedSuperclass
public class Message implements Serializable{
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "init")
	private int init;
    @Column(name = "bytes")
	private int bytes;
    @Column(name = "frame")
	private int frame;
    @Column(name = "crc")
	private int crc;
    @Column(name = "end")
	private int end;
	
	public Message(int init, int bytes, int frame, int crc, int end) {
		this.init  = init;
		this.bytes = bytes;
		this.frame = frame;
		this.crc   = crc;
		this.end   = end;
	}

	public int getInit() {
		return init;
	}

	public void setInit(int init) {
		this.init = init;
	}

	public int getBytes() {
		return bytes;
	}

	public void setBytes(int bytes) {
		this.bytes = bytes;
	}

	public int getFrame() {
		return frame;
	}

	public void setFrame(int frame) {
		this.frame = frame;
	}

	public int getCrc() {
		return crc;
	}

	public void setCrc(int crc) {
		this.crc = crc;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}
}
