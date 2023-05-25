package com.example.demo.DAL;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "Book")
@Getter
@Setter
@ToString
public class BookEntity {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;

	    
	    @Column(nullable = false)
		@NonNull
	    private String title;
	    
	    @Column(nullable = false)
		@NonNull
	    private String author;

	
	    
}
