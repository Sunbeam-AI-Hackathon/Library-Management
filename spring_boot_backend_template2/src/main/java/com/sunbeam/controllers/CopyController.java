package com.sunbeam.controllers;

import com.sunbeam.dto.CopyDto;
import com.sunbeam.dto.RackDto;
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
    
    
    
    
    @GetMapping("/rack/{rackid}")
    public ResponseEntity<List<RackDto>> getCopiesByRack(@PathVariable int rackid) {
        return ResponseEntity.ok(copyService.getCopiesByRack(rackid));
    }

    // PUT /api/copies/{id}/rack/{newRack}
    @PutMapping("/{id}/rack/{newRackid}")
    public ResponseEntity<RackDto> updateRack(@PathVariable int id, @PathVariable int newRackid) {
        RackDto updated = copyService.updateRack(id, newRackid);
        return (updated != null) ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }
    // 1. Add book to a rack
    @PostMapping("/add/{bookId}/rack/{rack}")
    public ResponseEntity<RackDto> addBookToRack(@PathVariable int bookId, @PathVariable int rack) {
        RackDto dto = copyService.addBookToRack(bookId, rack);
        return (dto != null) ? ResponseEntity.ok(dto) : ResponseEntity.badRequest().build();
    }


    // 3. Move book from one rack to another
    @PutMapping("/move/{copyId}/to/{newRack}")
    public ResponseEntity<RackDto> moveCopy(@PathVariable int copyId, @PathVariable int newRack) {
        RackDto moved = copyService.moveBookToAnotherRack(copyId, newRack);
        return (moved != null) ? ResponseEntity.ok(moved) : ResponseEntity.notFound().build();
    }

    // 4. Remove book from rack
    @DeleteMapping("/remove/{copyId}")
    public ResponseEntity<String> deleteCopyFromRack(@PathVariable int copyId) {
        boolean deleted = copyService.removeBookFromRack(copyId);
        return deleted ? ResponseEntity.ok("Removed successfully") : ResponseEntity.notFound().build();
    }
}
