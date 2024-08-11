package com.maids_library_management_system.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
	@NotBlank(message = "Title is required")
    @Size(max = 100, message = "Title must be less than 100 characters")
	private String title;
	
	@NotBlank(message = "Author is required")
    @Size(max = 50, message = "Author name must be less than 50 characters")
	private String author;
	
	@NotNull(message = "Publication year is required")
	private int publicationYear;
	
	@NotBlank(message = "ISBN is required")
    @Size(max = 26, message = "ISBN must be 26 characters or less")
	private String isbn;
}
