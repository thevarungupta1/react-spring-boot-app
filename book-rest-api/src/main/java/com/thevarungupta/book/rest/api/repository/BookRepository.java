package com.thevarungupta.book.rest.api.repository;

import com.thevarungupta.book.rest.api.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByTitle(String title);
}
