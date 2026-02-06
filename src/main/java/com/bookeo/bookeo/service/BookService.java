package com.bookeo.bookeo.service;

import com.bookeo.bookeo.models.Book;
import com.bookeo.bookeo.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository repo;

    public Book save(Book book) {
        return repo.save(book);
    }

    public List<Book> findAll() {
        return repo.findAll();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public List<Book> search(String q) {
        return repo.search(q);
    }
}
