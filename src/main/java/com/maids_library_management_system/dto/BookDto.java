package com.maids_library_management_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
	private String title;
	private String author;
	private int publicationYear;
	private String isbn;
}
