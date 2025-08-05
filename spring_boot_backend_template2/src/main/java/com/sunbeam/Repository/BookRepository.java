package com.sunbeam.Repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.Entity.Books;

public interface BookRepository extends JpaRepository<Books, Integer> {
}
