package com.sunbeam.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.Entity.Books;
import com.sunbeam.Repository.BookRepository;
import com.sunbeam.dto.BookDto;
import com.sunbeam.service.BookService;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Books addBook(BookDto dto) {
        Books book = new Books();
        book.setName(dto.getName());
        book.setAuthor(dto.getAuthor());
        book.setSubject(dto.getSubject());
        book.setPrice(dto.getPrice());
        book.setIsbn(dto.getIsbn());
        return bookRepository.save(book);
    }

	
}