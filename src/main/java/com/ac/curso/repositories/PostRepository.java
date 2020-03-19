package com.ac.curso.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.ac.curso.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{
	
	List<Post> findByTitleContaining(String text);
	
	@Query("{'title' : {$regex : ?0, 'i'} }")
	List<Post> findByTitle(String text);
	
	@Query("{ $and: [ {date: {$gte : ?1} }, {date: {$lte : ?2 }}, {$or: [{{'title' : {$regex : ?0, 'i'} }},"
			+ " {{'body' : {$regex : ?0, 'i'} }}, {{'comments.text' : {$regex : ?0, 'i'} }}] }] } }")
	List<Post> fullSearch(String text, Date minDate, Date maxDate);
}