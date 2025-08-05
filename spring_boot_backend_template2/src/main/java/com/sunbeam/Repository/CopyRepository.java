package com.sunbeam.Repository;

import com.sunbeam.Entity.Copy;
import com.sunbeam.Entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CopyRepository extends JpaRepository<Copy, Integer> {
    List<Copy> findByBook(Books book);
}
