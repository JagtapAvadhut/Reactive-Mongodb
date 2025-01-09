package com.spring.reactive.controller;

import com.spring.reactive.model.ApiResponse;
import com.spring.reactive.model.Book;
import com.spring.reactive.service.BookService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public Flux<ApiResponse<Book>> getAllBooks() {
        return bookService.getAllBooks()
                .map(book -> ApiResponse.success("Book fetched successfully", book));
    }

    @GetMapping("/{id}")
    public Mono<ApiResponse<Book>> getBookById(@PathVariable String id) {
        return bookService.getBookById(id)
                .map(book -> ApiResponse.success("Book fetched successfully", book))
                .defaultIfEmpty(ApiResponse.failure("Book not found", null));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ApiResponse<Book>> addBook(@Valid @RequestBody Book book) {
        log.info(" controller layer {} ",Thread.currentThread().getName());
        return bookService.addBook(book)
                .map(savedBook -> ApiResponse.success("Book added successfully", savedBook));
    }

    @DeleteMapping("/{id}")
    public Mono<ApiResponse<Void>> deleteBook(@PathVariable String id) {
        return bookService.deleteBook(id)
                .then(Mono.just(ApiResponse.success("Book deleted successfully", null)));
    }
}
