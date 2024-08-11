package com.maids_library_management_system.service.implementation;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.maids_library_management_system.dto.BorrowingRecordDto;
import com.maids_library_management_system.entity.Book;
import com.maids_library_management_system.entity.BorrowingRecord;
import com.maids_library_management_system.entity.Patron;
import com.maids_library_management_system.repository.BorrowingRecordRepository;
import com.maids_library_management_system.service.BookService;
import com.maids_library_management_system.service.BorrowingRecordService;
import com.maids_library_management_system.service.PatronService;

@Service
public class BorrowingRecordServiceImplementation implements BorrowingRecordService {
	@Autowired
	private final BorrowingRecordRepository borrowingRecordRepository;
	
	@Autowired
	private final BookService bookService;
	
	@Autowired
	private final PatronService patronService;

	public BorrowingRecordServiceImplementation(BorrowingRecordRepository borrowingRecordRepository,
			BookService bookService, PatronService patronService) {
		this.borrowingRecordRepository = borrowingRecordRepository;
		this.bookService = bookService;
		this.patronService = patronService;
	}

	@Override
	public BorrowingRecord addBorrowingRecord(Long bookId, Long patronId) {
		Optional<Book> bookOptional = bookService.getBookById(bookId);
		Optional<Patron> patronOptional = patronService.getPatronById(patronId);
		
		if (bookOptional.isPresent() && patronOptional.isPresent()) {
			BorrowingRecord borrowingRecord = new BorrowingRecord();
			
			Book book = bookOptional.get();
            Patron patron = patronOptional.get();
            
            borrowingRecord.setBook(book);
            borrowingRecord.setPatron(patron);
            borrowingRecord.setBorrowDate(new Date());
            
            return borrowingRecordRepository.save(borrowingRecord);
		}
		else {
            throw new IllegalArgumentException("Book or Patron not found");
        }
	}

	@Override
	public BorrowingRecord addReturnDate(Long bookId, Long patronId) {
		Optional<BorrowingRecord> borrowingRecordOptional = borrowingRecordRepository
	            .findByBookIdAndPatronIdAndReturnDateIsNull(bookId, patronId);

	    if (borrowingRecordOptional.isPresent()) {
	        BorrowingRecord borrowingRecord = borrowingRecordOptional.get();
	        borrowingRecord.setReturnDate(new Date());

	        return borrowingRecordRepository.save(borrowingRecord);
	    } else {
	        throw new IllegalArgumentException("Borrowing record not found or book already returned");
	    }
	}

}
