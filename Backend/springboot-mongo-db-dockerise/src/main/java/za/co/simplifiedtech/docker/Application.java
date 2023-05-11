package za.co.simplifiedtech.docker;

import za.co.simplifiedtech.docker.repository.BookRepository;
import za.co.simplifiedtech.docker.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/book")
public class Application {

    @Autowired
    private BookRepository repository;

    @PostMapping
    public Book saveBook(@RequestBody Book book) {
        return repository.save(book);
    }

    @GetMapping
    public List<Book> getBooks() {
        return repository.findAll();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
