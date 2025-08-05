package com.sunbeam.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CopyDto {
    private int id;
    private int bookId;
    private int rack;
    private String status;

    // Getters and Setters
}
