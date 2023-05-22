package za.co.simplifiedtech.springbootapachecamelh2.service;

import org.springframework.stereotype.Service;
import za.co.simplifiedtech.springbootapachecamelh2.model.Book;
import za.co.simplifiedtech.springbootapachecamelh2.repository.BookRepository;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Book findBookByName(String name) {
        return bookRepository.findBookByName(name);
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public void removeBook(int bookId) {
        bookRepository.deleteById(bookId);
    }
}
