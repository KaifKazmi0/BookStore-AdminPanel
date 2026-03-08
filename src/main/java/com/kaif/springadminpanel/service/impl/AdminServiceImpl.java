package com.kaif.springadminpanel.service.impl;

import com.kaif.springadminpanel.dto.Book;
import com.kaif.springadminpanel.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class AdminServiceImpl implements IAdminService {

    @Autowired
    private RestTemplate restTemplate;

    private String BASEURL = "http://localhost:8081/api/book";

    @Override
    public Book addBook(Book book) {
        String url = BASEURL;
        ResponseEntity<Book> response = restTemplate.postForEntity(url,book,Book.class);
        return response.getBody();
    }

    @Override
    public void updateBook(Long id, Book book) {
        String url = BASEURL+"/"+id;
        restTemplate.put(url,book);
    }


    @Override
    public void deleteBook(Long id) {
        String url = BASEURL+"/"+id;
        restTemplate.delete(url);
    }

    @Override
    public Book getById(Long id) {
        String url = BASEURL+"/"+id;
        ResponseEntity<Book> response = restTemplate.getForEntity(url,Book.class);
        return response.getBody();
    }

    @Override
    public List<Book> getByAuthor(String author) {

        String url = BASEURL + "/author/" + author;

        ResponseEntity<List<Book>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Book>>() {}
        );

        return response.getBody();
    }

    @Override
    public List<Book> getAll() {
        String url = BASEURL;
        ResponseEntity<List<Book>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Book>>(){});
        List<Book> books = response.getBody();
        return books;
    }
}
