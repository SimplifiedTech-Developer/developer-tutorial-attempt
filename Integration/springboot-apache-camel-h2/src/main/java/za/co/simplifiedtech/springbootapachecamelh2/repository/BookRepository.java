package za.co.simplifiedtech.springbootapachecamelh2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.simplifiedtech.springbootapachecamelh2.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    Book findBookByName(String name);
}
