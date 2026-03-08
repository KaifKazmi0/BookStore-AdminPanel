package com.kaif.springadminpanel.controller;

import com.kaif.springadminpanel.dto.Book;
import com.kaif.springadminpanel.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private IAdminService adminService;

    // POST http://localhost:8082/api/admin
    @PostMapping
    ResponseEntity<Book> addBook(@RequestBody Book book){
        Book book1 = adminService.addBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(book1);
    }

    // PUT http://localhost:8082/api/admin/{id}
    @PutMapping("/{id}")
    ResponseEntity<Void> updateBook(@PathVariable Long id,@RequestBody Book book){
        adminService.updateBook(id,book);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    // DELETE http://localhost:8082/api/admin/{id}
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteBook(@PathVariable Long id){
        adminService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

    // GET http://localhost:8082/api/admin/{id}
    @GetMapping("/{id}")
    ResponseEntity<Book> getById(@PathVariable Long id){
        Book book = adminService.getById(id);
        return ResponseEntity.ok(book);
    }

    // GET http://localhost:8082/api/admin/author/{author}
    @GetMapping("/author/{author}")
    ResponseEntity<List<Book>> getByAuthor(@PathVariable String author){
        List<Book> bookList = adminService.getByAuthor(author);
        return ResponseEntity.ok(bookList);
    }

    // GET http://localhost:8082/api/admin
    @GetMapping
    ResponseEntity<List<Book>> getAll(){
        List<Book> bookList = adminService.getAll();
        return ResponseEntity.ok(bookList);
    }

}