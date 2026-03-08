package com.kaif.springadminpanel.service;

import com.kaif.springadminpanel.dto.Book;

import java.util.List;

public interface IAdminService {
    Book addBook(Book book);
    void updateBook(Long id,Book book);
    void deleteBook(Long id);

    //Querying methods
    Book getById(Long id);
    List<Book> getByAuthor(String author);
    List<Book> getAll();
}
