package com.sunbeam.service;

import com.sunbeam.dto.CopyDto;
import com.sunbeam.dto.RackDto;

import java.util.List;

public interface CopyService {
    CopyDto addCopy(CopyDto dto);
    CopyDto updateCopy(int id, CopyDto dto);
    boolean deleteCopy(int id);
    List<CopyDto> getCopiesByBookId(int bookId);
    
    List<RackDto> getCopiesByRack(int rack);
    RackDto updateRack(int copyId, int newRack);
    
    RackDto addBookToRack(int bookId, int rack);
    RackDto moveBookToAnotherRack(int copyId, int newRack);
    boolean removeBookFromRack(int copyId);
}
