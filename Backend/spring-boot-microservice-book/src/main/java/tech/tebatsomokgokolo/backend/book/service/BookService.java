package tech.tebatsomokgokolo.backend.book.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tech.tebatsomokgokolo.backend.book.model.Book;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Slf4j
public class BookService {
    public Iterable<Book> getAll() {
        return Stream.of(new Book(1, "Spring", 100),
                new Book(2, "Java", 200),
                new Book(3, "Julia Caesar", 300.2))
                .collect(Collectors.toList());

    }
}
