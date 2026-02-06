package com.bookeo.bookeo.repository;

import com.bookeo.bookeo.models.Borrowing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface BorrowingRepository extends JpaRepository<Borrowing, Long> {

    @Query("""
        SELECT b.book.title, COUNT(b)
        FROM Borrowing b
        GROUP BY b.book.title
        ORDER BY COUNT(b) DESC
    """)
    List<Object[]> topBooks();
}
