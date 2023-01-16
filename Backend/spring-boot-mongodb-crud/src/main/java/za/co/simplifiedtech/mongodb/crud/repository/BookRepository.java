package za.co.simplifiedtech.mongodb.crud.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import za.co.simplifiedtech.mongodb.crud.model.Book;

public interface BookRepository extends MongoRepository<Book, Integer>{

}
