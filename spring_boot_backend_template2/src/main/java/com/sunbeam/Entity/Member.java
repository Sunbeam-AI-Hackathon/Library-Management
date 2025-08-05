package com.sunbeam.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "members")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String email;
    private String phone;
    private String passwd;
    private String role;

//    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
////    private List<IssueRecord> issueRecords;
//
//    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
//    private List<Payment> payments;
}
