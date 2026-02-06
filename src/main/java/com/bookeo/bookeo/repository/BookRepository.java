package com.bookeo.bookeo.repository;

import com.bookeo.bookeo.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("""
        SELECT b FROM Book b
        WHERE LOWER(b.title) LIKE LOWER(CONCAT('%', :q, '%'))
        OR LOWER(b.author) LIKE LOWER(CONCAT('%', :q, '%'))
        OR b.isbn LIKE CONCAT('%', :q, '%')
    """)
    List<Book> search(String q);
}
