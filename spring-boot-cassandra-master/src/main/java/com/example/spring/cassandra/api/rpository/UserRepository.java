package com.example.spring.cassandra.api.rpository;

import java.util.List;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;

import com.example.spring.cassandra.api.model.User;

public interface UserRepository extends CassandraRepository<User, Integer> {

	@AllowFiltering
	List<User> findById(int age);
	List<User> deleteById(int id);
}
