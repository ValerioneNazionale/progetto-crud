package com.example.demo.DAL;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;



public interface BookRepository extends JpaRepository<BookEntity, Integer>{
	
	List<BookEntity> findBookEntitiesByTitle(String title);
	List<BookEntity> findBookEntitiesByAuthor(String author);
		

}
