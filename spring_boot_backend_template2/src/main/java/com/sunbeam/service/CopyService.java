package com.sunbeam.service;

import com.sunbeam.dto.CopyDto;

import java.util.List;

public interface CopyService {
    CopyDto addCopy(CopyDto dto);
    CopyDto updateCopy(int id, CopyDto dto);
    boolean deleteCopy(int id);
    List<CopyDto> getCopiesByBookId(int bookId);
}
