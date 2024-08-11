package com.maids_library_management_system.service.implementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maids_library_management_system.entity.BorrowingRecord;
import com.maids_library_management_system.repository.BookRepository;
import com.maids_library_management_system.repository.BorrowingRecordRepository;
import com.maids_library_management_system.repository.PatronRepository;
import com.maids_library_management_system.service.BorrowingRecordService;

@Service
public class BorrowingRecordServiceImplementation implements BorrowingRecordService {

    @Autowired
    private final BorrowingRecordRepository borrowingRecordRepository;
    
    @Autowired
    private final BookRepository bookRepository;
    
    @Autowired
    private final PatronRepository patronRepository;

    public BorrowingRecordServiceImplementation(BorrowingRecordRepository borrowingRecordRepository, 
                                                BookRepository bookRepository, 
                                                PatronRepository patronRepository) {
        this.borrowingRecordRepository = borrowingRecordRepository;
        this.bookRepository = bookRepository;
        this.patronRepository = patronRepository;
    }

    public Optional<BorrowingRecord> addBorrowingRecord(Long bookId, Long patronId) {
        return bookRepository.findById(bookId)
                .flatMap(book -> patronRepository.findById(patronId)
                        .map(patron -> {
                            BorrowingRecord record = new BorrowingRecord();
                            record.setBook(book);
                            record.setPatron(patron);
                            record.setBorrowDate(new java.util.Date());
                            return borrowingRecordRepository.save(record);
                        }));
    }

    public Optional<BorrowingRecord> addReturnDate(Long bookId, Long patronId) {
        return borrowingRecordRepository.findByBookIdAndPatronIdAndReturnDateIsNull(bookId, patronId)
                .map(record -> {
                    record.setReturnDate(new java.util.Date());
                    return borrowingRecordRepository.save(record);
                });
    }
}
