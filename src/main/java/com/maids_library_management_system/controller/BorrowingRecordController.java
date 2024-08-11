package com.maids_library_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maids_library_management_system.entity.BorrowingRecord;
import com.maids_library_management_system.exception.BookNotFoundException;
import com.maids_library_management_system.service.implementation.BorrowingRecordServiceImplementation;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@Slf4j
public class BorrowingRecordController {

    @Autowired
    private final BorrowingRecordServiceImplementation borrowingRecordServiceImplementation;

    public BorrowingRecordController(BorrowingRecordServiceImplementation borrowingRecordServiceImplementation) {
        this.borrowingRecordServiceImplementation = borrowingRecordServiceImplementation;
    }

    @PostMapping("/borrow/{bookId}/patron/{patronId}")
    public ResponseEntity<BorrowingRecord> borrowBook(@PathVariable Long bookId, @PathVariable Long patronId) {
        return borrowingRecordServiceImplementation.addBorrowingRecord(bookId, patronId)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new BookNotFoundException("Book or Patron not found with ids " + bookId + " and " + patronId));
    }

    @PutMapping("/return/{bookId}/patron/{patronId}")
    public ResponseEntity<BorrowingRecord> returnBook(@PathVariable Long bookId, @PathVariable Long patronId) {
        return borrowingRecordServiceImplementation.addReturnDate(bookId, patronId)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new BookNotFoundException("Borrowing record not found for book id " + bookId + " and patron id " + patronId));
    }
}
