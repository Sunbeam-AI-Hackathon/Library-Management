package com.sunbeam.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "issuerecord")

public class IssueRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @ManyToOne
//    @JoinColumn(name = "copyid")
//    private Copy copy;
//
    @ManyToOne
    @JoinColumn(name = "memberid")
    private Member member;

    private LocalDateTime issued;
    private LocalDateTime returndue;
    private LocalDateTime returned;
    private double fine;
}
