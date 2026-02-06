package com.bookeo.bookeo.endpoint.rest.controller;

import com.bookeo.bookeo.service.BorrowingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/borrowings")
@RequiredArgsConstructor
public class BorrowingController {

    private final BorrowingService service;

    @PostMapping("/borrow")
    public void borrow(@RequestParam Long userId, @RequestParam Long bookId) {
        service.borrow(userId, bookId);
    }

    @PostMapping("/return/{id}")
    public void returnBook(@PathVariable Long id) {
        service.returnBook(id);
    }
}

