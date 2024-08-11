package com.maids_library_management_system.dto;

import java.util.Date;

import com.maids_library_management_system.entity.Book;
import com.maids_library_management_system.entity.Patron;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BorrowingRecordDto {
	@NotNull(message = "Book is required")
    private Book book;

    @NotNull(message = "Patron is required")
    private Patron patron;

    @NotNull(message = "Borrow date is required")
    private Date borrowDate;
}
