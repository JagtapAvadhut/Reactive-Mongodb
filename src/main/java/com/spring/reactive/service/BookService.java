package com.spring.reactive.service;

import com.spring.reactive.model.Book;
import com.spring.reactive.repository.BookRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookService {

    private static final Logger log = LoggerFactory.getLogger(BookService.class);
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Flux<Book> getAllBooks() {
        log.debug("Fetching all books from MongoDB");
        return bookRepository.findAll()
                .doOnError(e -> log.error("Error fetching books: {}", e.getMessage()));
    }

    public Mono<Book> getBookById(String id) {
        log.debug("Fetching book by ID: {}", id);
        return bookRepository.findById(id)
                .doOnError(e -> log.error("Error fetching book: {}", e.getMessage()));
    }

    public Mono<Book> addBook(Book book) {
        log.debug("Adding new book: {}", book);
        log.info(" service layer {} ",Thread.currentThread().getName());
        return bookRepository.save(book)
                .doOnError(e -> log.error("Error adding book: {}", e.getMessage()));
    }

    public Mono<Void> deleteBook(String id) {
        log.debug("Deleting book by ID: {}", id);
        return bookRepository.deleteById(id)
                .doOnError(e -> log.error("Error deleting book: {}", e.getMessage()));
    }
}
