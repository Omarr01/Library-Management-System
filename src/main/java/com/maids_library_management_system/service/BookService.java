package com.maids_library_management_system.service;

import java.util.List;
import java.util.Optional;
import com.maids_library_management_system.dto.BookDto;
import com.maids_library_management_system.entity.Book;

public interface BookService {
	public List<Book> getAllBooks();

	public Optional<Book> getBookById(Long id);

	public Book addBook(BookDto bookDto);
	
	public Book updateBook(Long id, BookDto bookDetails);

	public void deleteBook(Long id);
}
