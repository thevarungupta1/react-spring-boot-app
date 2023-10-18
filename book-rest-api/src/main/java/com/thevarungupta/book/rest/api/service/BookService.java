package com.thevarungupta.book.rest.api.service;

import com.thevarungupta.book.rest.api.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    Book getBookById(Long id);
    Book getBookByTitle(String title);
    Book updateBook(Long id, Book updateBook);
    Book createBook(Book newBook);
    void deleteBook(Long id);
}
