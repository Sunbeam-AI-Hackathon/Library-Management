package com.sunbeam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
}
