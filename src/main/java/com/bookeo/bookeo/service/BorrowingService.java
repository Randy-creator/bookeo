package com.bookeo.bookeo.service;

import com.bookeo.bookeo.models.Book;
import com.bookeo.bookeo.models.Borrowing;
import com.bookeo.bookeo.models.User;
import com.bookeo.bookeo.repository.BookRepository;
import com.bookeo.bookeo.repository.BorrowingRepository;
import com.bookeo.bookeo.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class BorrowingService {

    private final BorrowingRepository borrowRepo;
    private final BookRepository bookRepo;
    private final UserRepository userRepo;

    @Transactional
    public void borrow(Long userId, Long bookId) {
        Book book = bookRepo.findById(bookId).orElseThrow();

        if (book.getStock() <= 0) {
            throw new RuntimeException("Stock épuisé");
        }

        User user = userRepo.findById(userId).orElseThrow();

        book.setStock(book.getStock() - 1);

        Borrowing borrowing = Borrowing.builder()
                .book(book)
                .user(user)
                .build();

        borrowRepo.save(borrowing);
    }

    @Transactional
    public void returnBook(Long borrowingId) {
        Borrowing borrowing = borrowRepo.findById(borrowingId).orElseThrow();

        borrowing.setReturnedAt(LocalDateTime.now());

        Book book = borrowing.getBook();
        book.setStock(book.getStock() + 1);
    }
}
