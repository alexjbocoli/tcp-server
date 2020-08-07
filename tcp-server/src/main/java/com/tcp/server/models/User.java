package com.tcp.server.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe modelo para o usuário
 * @author Alex Juno Bócoli
 *
 */
@Entity
@Table(name = "user")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
	
    @Column(name = "age")
	private int age;
    @Column(name = "weight")
	private int weight;
    @Column(name = "height")
	private int height;
    @Column(name = "name")
	private String name;
    @Column(name = "name_size")
	private int nameSize;
	
    /**
     * Construtor
     * @param age a idade
     * @param weight o peso
     * @param height a altura
     * @param nameSize o tamanho do nome
     * @param name o nome
     */
	public User(int age, int weight, int height, int nameSize, String name) {
		this.age = age;
		this.weight = weight;
		this.height = height;
		this.nameSize = nameSize;
		this.name = name;
	}

	/**
	 * Retorna o nome
	 * @return o nome
	 */
	public String getName() {
		return name;
	}

	/**
	 * Define o nome
	 * @param name o nome
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Retorna o tamanho do nome
	 * @return o tamanho do nome
	 */
	public int getNameSize() {
		return nameSize;
	}

	/**
	 * Define o tamanho do nome
	 * @param nameSize o tamanho do nome
	 */
	public void setNameSize(int nameSize) {
		this.nameSize = nameSize;
	}

	/**
	 * Retorna a idade
	 * @return a idade
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Define a idade
	 * @param age a idade
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Retorna o peso
	 * @return o peso
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * Define o peso
	 * @param weight o peso
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

	/**
	 * Retorna a altura
	 * @return a altura
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Define a altura
	 * @param height a altura
	 */
	public void setHeight(int height) {
		this.height = height;
	}
}
