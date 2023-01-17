package za.co.simplifiedtech.docker.repository;

import za.co.simplifiedtech.docker.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book,Integer> {
}
