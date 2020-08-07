package com.tcp.server.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Classe modelo para a mensagem de texto
 * @author Alex Juno Bócoli
 *
 */
@Entity
@Table(name = "messagetext")
public class MessageText extends Message implements Serializable {
	private static final long serialVersionUID = 1L;
	
    @Column(name = "data")
	private String data;
    @Column(name = "registration_date")
    private String dateTime;
	
    /**
     * Construtor
     * @param init o byte inicial do protocolo
     * @param bytes o tamanho do protocolo
     * @param frame o tipo do frame
     * @param crc o crc
     * @param end o byte final do protocolo
     * @param data a mensagem de texto
     * @param dateTime a data e hora de inclusão no banco de dados
     */
	public MessageText(int init, int bytes, int frame, int crc, int end, String data, String dateTime) {
		super(init, bytes, frame, crc, end);
		this.data = data;
		this.dateTime = dateTime;
	}

	/**
	 * Retorna a mensagem de texto
	 * @return a mensagem de texto
	 */
	public String getData() {
		return data;
	}

	/**
	 * Define a mensagem de texto
	 * @param data amensagem de texto
	 */
	public void setData(String data) {
		this.data = data;
	}
	
	/**
	 * Retorna a data e hora de inclusão
	 * @return a data e hora de inclusão
	 */
	public String getDateTime() {
		return dateTime;
	}

	/**
	 * Define a data e hora de inclusão
	 * @param dateTime a data e hora de inclusão
	 */
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
}
