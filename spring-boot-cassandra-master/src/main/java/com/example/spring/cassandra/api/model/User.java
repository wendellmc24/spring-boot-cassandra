package com.example.spring.cassandra.api.model;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	public User(int id, String name, String address, int age) {
		this.id= id;
		this.name= name;
		this.address= address;
		this.age= age;
	}
	@PrimaryKey
	private int id;
	private String name;
	private String address;
	private int age;

}
 