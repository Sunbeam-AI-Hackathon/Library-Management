package com.sunbeam.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Copy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "bookid")
    private Books book;

    private int rack;
    private String status;

//    @OneToMany(mappedBy = "copy")
//    private List<IssueRecord> issueRecords;

    // getters and setters
}