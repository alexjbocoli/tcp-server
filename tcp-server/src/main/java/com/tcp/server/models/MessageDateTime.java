package com.tcp.server.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Classe modelo para a mensagem data/hora
 * @author Alex Juno Bócoli
 *
 */
@Entity
@Table(name = "messagedatetime")
public class MessageDateTime extends Message implements Serializable {
	private static final long serialVersionUID = 1L;
	
    @Column(name = "data")
	private DateTime data;
	
    /**
     * Construtor
     * @param init o byte inicial do protocolo
     * @param bytes o tamanho do protocolo
     * @param frame o tipo do frame
     * @param crc o crc
     * @param end o byte final do protocolo
     * @param data a data e a hora
     */
	public MessageDateTime(int init, int bytes, int frame, int crc, int end, DateTime data) {
		super(init, bytes, frame, crc, end);
		this.data = data;
	}

	/**
	 * Retorna a data e a hora
	 * @return a data e a hora
	 */
	public DateTime getData() {
		return data;
	}

	/**
	 * Define a data e a hora
	 * @param data a data e a hora
	 */
	public void setData(DateTime data) {
		this.data = data;
	}
}
