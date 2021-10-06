package tech.tebatsomokgokolo.backend.book.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.tebatsomokgokolo.backend.book.model.Book;
import tech.tebatsomokgokolo.backend.book.service.BookService;

import java.util.Objects;

@RestController
@RequestMapping(path = "v1/api/book")
@Slf4j
public class BookController {
    @Autowired
    private BookService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin("http://localhost:4200")
    public @ResponseBody
    ResponseEntity<Object> getAll() {

        log.info("Started Getting All Students ");
        Iterable<Book> all = service.getAll();
        if (!Objects.isNull(all)) {
            log.info("Completed  All Getting Students");
            return new ResponseEntity<>(all, HttpStatus.OK);
        } else {
            log.info("Completed Getting Student ");
            return new ResponseEntity<>("Student(s) Not found", HttpStatus.BAD_REQUEST);
        }
    }
}
