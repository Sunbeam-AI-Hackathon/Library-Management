package com.sunbeam.serviceImpl;

import java.util.Optional;

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
    @Override
    public boolean deleteBookById(int id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return true;
        }
        return false;
    }
    
    @Override
    public BookDto updateBook(int id, BookDto updatedDto) {
        Optional<Books> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Books book = optionalBook.get();

            book.setName(updatedDto.getName());
            book.setAuthor(updatedDto.getAuthor());
            book.setSubject(updatedDto.getSubject());
            book.setPrice(updatedDto.getPrice());
            book.setIsbn(updatedDto.getIsbn());

            Books updatedBook = bookRepository.save(book);

            // Convert entity to DTO
            BookDto result = new BookDto();
            result.setId(updatedBook.getId());
            result.setName(updatedBook.getName());
            result.setAuthor(updatedBook.getAuthor());
            result.setSubject(updatedBook.getSubject());
            result.setPrice(updatedBook.getPrice());
            result.setIsbn(updatedBook.getIsbn());

            return result;
        }
        return null;
    }

	
}