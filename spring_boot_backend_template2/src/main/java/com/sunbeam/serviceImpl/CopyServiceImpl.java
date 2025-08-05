package com.sunbeam.serviceImpl;

import com.sunbeam.dto.CopyDto;
import com.sunbeam.Entity.Books;
import com.sunbeam.Entity.Copy;
import com.sunbeam.Repository.BookRepository;
import com.sunbeam.Repository.CopyRepository;
import com.sunbeam.service.CopyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CopyServiceImpl implements CopyService {

    @Autowired
    private CopyRepository copyRepository;

    @Autowired
    private BookRepository booksRepository;

    @Override
    public CopyDto addCopy(CopyDto dto) {
        Optional<Books> optionalBook = booksRepository.findById(dto.getBookId());
        if (optionalBook.isPresent()) {
            Copy copy = new Copy();
            copy.setBook(optionalBook.get());
            copy.setRack(dto.getRack());
            copy.setStatus(dto.getStatus());

            Copy savedCopy = copyRepository.save(copy);
            dto.setId(savedCopy.getId());
            return dto;
        }
        return null;
    }

    @Override
    public CopyDto updateCopy(int id, CopyDto dto) {
        Optional<Copy> optionalCopy = copyRepository.findById(id);
        if (optionalCopy.isPresent()) {
            Copy copy = optionalCopy.get();
            copy.setRack(dto.getRack());
            copy.setStatus(dto.getStatus());

            copyRepository.save(copy);
            dto.setId(copy.getId());
            dto.setBookId(copy.getBook().getId());
            return dto;
        }
        return null;
    }

    @Override
    public boolean deleteCopy(int id) {
        if (copyRepository.existsById(id)) {
            copyRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<CopyDto> getCopiesByBookId(int bookId) {
        Optional<Books> optionalBook = booksRepository.findById(bookId);
        if (optionalBook.isPresent()) {
            List<Copy> copies = copyRepository.findByBook(optionalBook.get());
            List<CopyDto> dtos = new ArrayList<>();
            for (Copy c : copies) {
                CopyDto dto = new CopyDto();
                dto.setId(c.getId());
                dto.setBookId(bookId);
                dto.setRack(c.getRack());
                dto.setStatus(c.getStatus());
                dtos.add(dto);
            }
            return dtos;
        }
        return Collections.emptyList();
    }
}
