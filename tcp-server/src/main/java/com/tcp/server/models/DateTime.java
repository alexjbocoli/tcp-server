package com.tcp.server.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "datetime")
public class DateTime implements Serializable {
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
	
    @Column(name = "day")
	private int day;
    @Column(name = "month")
	private int month;
    @Column(name = "year")
	private int year;
    @Column(name = "hour")
	private int hour;
    @Column(name = "minute")
	private int minute;
    @Column(name = "second")
	private int second;
	
	public DateTime(int day, int month, int year, int hour, int minute, int second) {
		this.day        = day;
		this.month      = month;
		this.year       = year;
		this.hour       = hour;
		this.minute     = minute;
		this.second     = second;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}
}

