package com.sunbeam.serviceImpl;

import com.sunbeam.dto.CopyDto;
import com.sunbeam.dto.RackDto;
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
    
    @Override
    public List<RackDto> getCopiesByRack(int rack) {
        List<Copy> copies = copyRepository.findByRack(rack);
        List<RackDto> result = new ArrayList<>();

        for (Copy copy : copies) {
            RackDto dto = new RackDto();
            dto.setId(copy.getId());
            dto.setBookId(copy.getBook().getId());
            dto.setBookName(copy.getBook().getName());
            dto.setRack(copy.getRack());
            dto.setStatus(copy.getStatus());
            result.add(dto);
        }

        return result;
    }

    @Override
    public RackDto updateRack(int copyId, int newRack) {
        Optional<Copy> optionalCopy = copyRepository.findById(copyId);
        if (optionalCopy.isPresent()) {
            Copy copy = optionalCopy.get();
            copy.setRack(newRack);
            Copy updated = copyRepository.save(copy);

            RackDto dto = new RackDto();
            dto.setId(updated.getId());
            dto.setBookId(updated.getBook().getId());
            dto.setBookName(updated.getBook().getName());
            dto.setRack(updated.getRack());
            dto.setStatus(updated.getStatus());
            return dto;
        }
        return null;
    }

    public RackDto addBookToRack(int bookId, int rack) {
        Optional<Books> optionalBook = booksRepository.findById(bookId);
        if (optionalBook.isPresent()) {
            Copy copy = new Copy();
            copy.setBook(optionalBook.get());
            copy.setRack(rack);
            copy.setStatus("Available");

            Copy saved = copyRepository.save(copy);

            RackDto dto = new RackDto();
            dto.setId(saved.getId());
            dto.setBookId(bookId);
            dto.setBookName(saved.getBook().getName());
            dto.setRack(saved.getRack());
            dto.setStatus(saved.getStatus());
            return dto;
        }
        return null;
    }
    
    @Override
    public RackDto moveBookToAnotherRack(int copyId, int newRack) {
        Optional<Copy> optionalCopy = copyRepository.findById(copyId);
        if (optionalCopy.isPresent()) {
            Copy copy = optionalCopy.get();
            copy.setRack(newRack);
            copyRepository.save(copy);

            RackDto dto = new RackDto();
            dto.setId(copy.getId());
            dto.setBookId(copy.getBook().getId());
            dto.setBookName(copy.getBook().getName());
            dto.setRack(copy.getRack());
            dto.setStatus(copy.getStatus());
            return dto;
        }
        return null;
    }

    @Override
    public boolean removeBookFromRack(int copyId) {
        if (copyRepository.existsById(copyId)) {
            copyRepository.deleteById(copyId);
            return true;
        }
        return false;
    }

}
