package com.tcp.server.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe modelo para a data e hora
 * @author Alex Juno Bócoli
 *
 */
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
	
    /**
     * Construtor
     * @param day o dia
     * @param month o mês
     * @param year o ano
     * @param hour as horas
     * @param minute os minutos
     * @param second os segundos
     */
	public DateTime(int day, int month, int year, int hour, int minute, int second) {
		this.day        = day;
		this.month      = month;
		this.year       = year;
		this.hour       = hour;
		this.minute     = minute;
		this.second     = second;
	}

	/**
	 * Retorna o dia
	 * @return o dia
	 */
	public int getDay() {
		return day;
	}

	/**
	 * Define o dia
	 * @param day o dia
	 */
	public void setDay(int day) {
		this.day = day;
	}

	/**
	 * Retorna o mês
	 * @return o mês
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * Define o mês
	 * @param month o mês
	 */
	public void setMonth(int month) {
		this.month = month;
	}

	/**
	 * Retorna o ano
	 * @return o ano
	 */
	public int getYear() {
		return year;
	}

	/**
	 * Define o ano
	 * @param year o ano
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * Retorna as horas
	 * @return as horas
	 */
	public int getHour() {
		return hour;
	}

	/**
	 * Define as horas
	 * @param hour as horas
	 */
	public void setHour(int hour) {
		this.hour = hour;
	}

	/**
	 * Retorna os minutos
	 * @return os minutos
	 */
	public int getMinute() {
		return minute;
	}

	/**
	 * Define os minutos
	 * @param minute os minutos
	 */
	public void setMinute(int minute) {
		this.minute = minute;
	}

	/**
	 * Retorna os segundos
	 * @return os segundos
	 */
	public int getSecond() {
		return second;
	}

	/**
	 * Define os segundos
	 * @param second os segundos
	 */
	public void setSecond(int second) {
		this.second = second;
	}
}

