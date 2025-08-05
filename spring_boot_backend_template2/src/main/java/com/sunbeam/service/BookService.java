package com.sunbeam.service;

import com.sunbeam.Entity.Books;
import com.sunbeam.dto.BookDto;

public interface BookService {
    Books addBook(BookDto bookDto);
    boolean deleteBookById(int id);
    BookDto updateBook(int id, BookDto updatedBookDto);
}
