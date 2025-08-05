package com.sunbeam.controllers;

import com.sunbeam.dto.CopyDto;
import com.sunbeam.service.CopyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/copy")
public class CopyController {

    @Autowired
    private CopyService copyService;

    @PostMapping
    public ResponseEntity<CopyDto> addCopy(@RequestBody CopyDto dto) {
        CopyDto added = copyService.addCopy(dto);
        return (added != null) ? ResponseEntity.ok(added) : ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CopyDto> updateCopy(@PathVariable int id, @RequestBody CopyDto dto) {
        CopyDto updated = copyService.updateCopy(id, dto);
        return (updated != null) ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCopy(@PathVariable int id) {
        boolean deleted = copyService.deleteCopy(id);
        return deleted ? ResponseEntity.ok("Deleted successfully") : ResponseEntity.notFound().build();
    }

    @GetMapping("/book/{bookId}")
    public ResponseEntity<List<CopyDto>> getCopiesByBookId(@PathVariable int bookId) {
        return ResponseEntity.ok(copyService.getCopiesByBookId(bookId));
    }
}
