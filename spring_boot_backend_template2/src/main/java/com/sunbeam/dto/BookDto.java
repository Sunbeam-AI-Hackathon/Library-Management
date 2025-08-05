package com.sunbeam.dto;
import lombok.Data;

@Data
public class BookDto {
	private int id;
    private String name;
    private String author;
    private String subject;
    private double price;
    private String isbn;
}
