package com.tcp.server.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	
	public User(int age, int weight, int height, int nameSize, String name) {
		this.age = age;
		this.weight = weight;
		this.height = height;
		this.nameSize = nameSize;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNameSize() {
		return nameSize;
	}

	public void setNameSize(int nameSize) {
		this.nameSize = nameSize;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}
