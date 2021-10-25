package com.springbootmongodbcrud.sample.repository;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springbootmongodbcrud.sample.entity.Student;


public interface UserRepository extends MongoRepository<Student, String> {
	List<Student> findByOrderByNameAsc();

}