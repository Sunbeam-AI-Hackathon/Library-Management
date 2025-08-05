package com.sunbeam.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RackDto {
    private int id;
    private int bookId;
    private String bookName;
    private int rack;
    private String status;

    // Getters and Setters
}
