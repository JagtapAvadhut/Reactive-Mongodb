package com.spring.reactive.repository;

import com.spring.reactive.model.Book;
import org.springframework.stereotype.Repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
//import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
//
public interface BookRepository extends ReactiveMongoRepository<Book, String> {
//@Repository
//public interface BookRepository extends ReactiveCassandraRepository<Book, String> {

}
