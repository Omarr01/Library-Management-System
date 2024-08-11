package com.maids_library_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maids_library_management_system.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
