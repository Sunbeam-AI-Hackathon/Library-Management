package com.sunbeam.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Copy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "bookid", nullable = false)
    private Books book;

    @Column(nullable = false)
    private int rack;

    @Column(nullable = false)
    private String status;

    // Getters and Setters
}
