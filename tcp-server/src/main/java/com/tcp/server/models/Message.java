package com.tcp.server.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Superclasse modelo para a mensagem
 * @author Alex Juno Bócoli
 *
 */
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
	
    /**
     * Construtor
     * @param init o byte inicial do protocolo
     * @param bytes o tamanho do protocolo
     * @param frame o tipo do frame
     * @param crc o crc
     * @param end o byte final do protocolo
     */
	public Message(int init, int bytes, int frame, int crc, int end) {
		this.init  = init;
		this.bytes = bytes;
		this.frame = frame;
		this.crc   = crc;
		this.end   = end;
	}

	/**
	 * Retorno o byte inicial
	 * @return o byte inicial
	 */
	public int getInit() {
		return init;
	}

	/**
	 * Define o byte inicial
	 * @param init o byte inicial
	 */
	public void setInit(int init) {
		this.init = init;
	}

	/**
	 * Retorna o tamanho do protocolo
	 * @return o tamanho do protocolo
	 */
	public int getBytes() {
		return bytes;
	}

	/**
	 * Define o tamanho do protocolo
	 * @param bytes o tamanho do protocolo
	 */
	public void setBytes(int bytes) {
		this.bytes = bytes;
	}

	/**
	 * Retorna o frame
	 * @return o frame
	 */
	public int getFrame() {
		return frame;
	}

	/**
	 * Define o frame
	 * @param frame o frame
	 */
	public void setFrame(int frame) {
		this.frame = frame;
	}

	/**
	 * Retorna o CRC
	 * @return o crc
	 */
	public int getCrc() {
		return crc;
	}

	/**
	 * Define o CRC
	 * @param crc o crc
	 */
	public void setCrc(int crc) {
		this.crc = crc;
	}

	/**
	 * Retorna o byte final
	 * @return o byte final
	 */
	public int getEnd() {
		return end;
	}

	/**
	 * Define o byte final
	 * @param end o byte final
	 */
	public void setEnd(int end) {
		this.end = end;
	}
}
