package com.maids_library_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.maids_library_management_system.dto.BookDto;
import com.maids_library_management_system.entity.Book;
import com.maids_library_management_system.exception.BookNotFoundException;
import com.maids_library_management_system.service.implementation.BookServiceImplementation;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@Slf4j
public class BookController {
	@Autowired
	private final BookServiceImplementation bookServiceImplementation;

	public BookController(BookServiceImplementation bookServiceImplementation) {
		this.bookServiceImplementation = bookServiceImplementation;
	}

	@GetMapping
	public List<Book> getAllBooks() {
		return bookServiceImplementation.getAllBooks();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable Long id) {
		return bookServiceImplementation.getBookById(id).map(ResponseEntity::ok)
				.orElseThrow(() -> new BookNotFoundException("Book not found with id " + id));
	}

	@PostMapping
	public Book addBook(@Valid @RequestBody BookDto bookDto) {
		return bookServiceImplementation.addBook(bookDto);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable Long id, @Valid @RequestBody BookDto bookDetails) {
	    return bookServiceImplementation.updateBook(id, bookDetails)
	        .map(ResponseEntity::ok)
	        .orElseThrow(() -> new BookNotFoundException("Book not found with id " + id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
	    bookServiceImplementation.deleteBook(id)
	        .orElseThrow(() -> new BookNotFoundException("Book not found with id " + id));
	    return ResponseEntity.noContent().build();
	}
}
