package com.maids_library_management_system.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maids_library_management_system.dto.BookDto;
import com.maids_library_management_system.entity.Book;
import com.maids_library_management_system.repository.BookRepository;
import com.maids_library_management_system.service.BookService;

@Service
public class BookServiceImplementation implements BookService {
	@Autowired
	private final BookRepository bookRepository;

	public BookServiceImplementation(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	@Override
	public Optional<Book> getBookById(Long id) {
		return bookRepository.findById(id);
	}

	@Override
	public Book addBook(BookDto bookDto) {
		Book book = new Book();
		BeanUtils.copyProperties(bookDto, book);
		return bookRepository.save(book);
	}
	
	@Override
	public Optional<Book> updateBook(Long id, BookDto bookDetails) {
		return bookRepository.findById(id).map(book -> {
	        book.setTitle(bookDetails.getTitle());
	        book.setAuthor(bookDetails.getAuthor());
	        book.setPublicationYear(bookDetails.getPublicationYear());
	        book.setIsbn(bookDetails.getIsbn());
	        return bookRepository.save(book);
	    });
	}
	
	@Override
	public Optional<Book> deleteBook(Long id) {
	    return bookRepository.findById(id).map(book -> {
	        bookRepository.delete(book);
	        return book;
	    });
	}
}
