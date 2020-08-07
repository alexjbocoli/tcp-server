package com.tcp.server.models;

import java.io.Serializable;

/**
 * Classe modelo para o fuso horário: não utilizada pois o servidor cria a tabela TIMEZONE no banco de dados na inicialização 
 * por meio do arquivo "schema.sql" localizado em "\src\main\resources"
 * @author GP-ALEX
 *
 */
//@Entity
//@Table(name = "timezone")
public class Timezone implements Serializable {
	private static final long serialVersionUID = 1L;
	
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
