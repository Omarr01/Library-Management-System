package com.maids_library_management_system.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatronDto {
	@NotBlank(message = "Name is required")
	@Size(max = 50, message = "Name must be less than 50 characters")
	private String name;

	@NotBlank(message = "Email is required")
	@Email(message = "Email should be valid")
	private String email;

	@NotBlank(message = "Phone number is required")
	@Size(max = 30, message = "Phone number should be between 10 and 15 characters")
	private String phoneNumber;
}
