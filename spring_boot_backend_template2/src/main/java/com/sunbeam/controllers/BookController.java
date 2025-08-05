package com.sunbeam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.Entity.Books;
import com.sunbeam.dto.BookDto;
import com.sunbeam.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<Books> addBook(@RequestBody BookDto bookDto) {
        Books savedBook = bookService.addBook(bookDto);
        return ResponseEntity.ok(savedBook);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable int id) {
        boolean isDeleted = bookService.deleteBookById(id);
        if (isDeleted) {
            return ResponseEntity.ok("Book deleted successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<BookDto> updateBook(@PathVariable int id, @RequestBody BookDto bookDto) {
        BookDto updated = bookService.updateBook(id, bookDto);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
