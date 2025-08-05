package com.sunbeam.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

	@Entity
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@Table(name = "payments")
	
	public class Payment 
	{
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

	    @ManyToOne
	    @JoinColumn(name = "memberid")
	    private Member member;

	    private double amount;
	    private String type;
	    private LocalDateTime txtime;
	    private LocalDateTime duedate;
}

