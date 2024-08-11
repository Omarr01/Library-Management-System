package com.maids_library_management_system.dto;

import java.util.Date;

import com.maids_library_management_system.entity.Book;
import com.maids_library_management_system.entity.Patron;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BorrowingRecordDto {
	private Book book;
	private Patron patron;
	private Date borrowDate;
}
