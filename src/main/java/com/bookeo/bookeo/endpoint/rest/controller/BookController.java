package com.bookeo.bookeo.endpoint.rest.controller;

import com.bookeo.bookeo.models.Book;
import com.bookeo.bookeo.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService service;

    @GetMapping
    public List<Book> all() {
        return service.findAll();
    }

    @PostMapping
    public Book create(@RequestBody Book book) {
        return service.save(book);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/search")
    public List<Book> search(@RequestParam String q) {
        return service.search(q);
    }
}

