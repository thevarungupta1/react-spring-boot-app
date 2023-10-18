package com.thevarungupta.book.rest.api.service.impl;

import com.thevarungupta.book.rest.api.entity.Book;
import com.thevarungupta.book.rest.api.repository.BookRepository;
import com.thevarungupta.book.rest.api.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long id) {
        Book book =  bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("book not found with id: "+ id));
        return book;
    }

    @Override
    public Book getBookByTitle(String title) {
        Book book = bookRepository.findByTitle(title)
                .orElseThrow(() -> new RuntimeException("book not found with title: "+ title));
        return book;
    }

    @Override
    public Book updateBook(Long id, Book updateBook) {
        Book book =  bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("book not found with id: "+ id));
        book.setTitle(updateBook.getTitle());
        book.setAuthor(updateBook.getAuthor());
        book.setPrice(updateBook.getPrice());
        return bookRepository.save(book);
    }

    @Override
    public Book createBook(Book newBook) {
        return bookRepository.save(newBook);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
