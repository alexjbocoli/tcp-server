package com.tcp.server.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity
//@Table(name = "timezone")
public class Timezone implements Serializable {
	private static final long serialVersionUID = 1L;
	
    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "id")
	private int id;
	
    //@Column(name = "location")
	private String location;
    //@Column(name = "timezone")
	private String timezone;
    //@Column(name = "hour_offset")
	private int hourOffset;
    //@Column(name = "minute_offset")
	private int minuteOffset;
    //@Column(name = "balance")
	private String balance;
	
	public Timezone(String location, String timezone, int hourOffset, int minuteOffset, String balance) {
		this.location = location;
		this.timezone = timezone;
		this.hourOffset = hourOffset;
		this.minuteOffset = minuteOffset;
		this.balance = balance;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public int getHourOffset() {
		return hourOffset;
	}

	public void setHourOffset(int hourOffset) {
		this.hourOffset = hourOffset;
	}

	public int getMinuteOffset() {
		return minuteOffset;
	}

	public void setMinuteOffset(int minuteOffset) {
		this.minuteOffset = minuteOffset;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}
}
