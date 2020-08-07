package com.tcp.server.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Classe modelo para a mensagem de usuário
 * @author Alex Juno Bócoli
 *
 */
@Entity
@Table(name = "messageuser")
public class MessageUser extends Message implements Serializable{
	private static final long serialVersionUID = 1L;
	
    @Column(name = "data")
	private User data;
	
    /**
     * Construtor
     * @param init o byte inicial do protocolo
     * @param bytes o tamanho do protocolo
     * @param frame o tipo do frame
     * @param crc o crc
     * @param end o byte final do protocolo
     * @param data o usuário
     */
	public MessageUser(int init, int bytes, int frame, int crc, int end, User data) {
		super(init, bytes, frame, crc, end);
		this.data = data;
	}

	/**
	 * Retorna o usuário
	 * @return o usuário
	 */
	public User getData() {
		return data;
	}

	/**
	 * Define o usuário
	 * @param data o usuário
	 */
	public void setData(User data) {
		this.data = data;
	}
}
