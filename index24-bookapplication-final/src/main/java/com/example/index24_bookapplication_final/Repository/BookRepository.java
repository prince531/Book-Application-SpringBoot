package com.example.index24_bookapplication_final.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.index24_bookapplication_final.Entity.BookEntity;
@Repository
public interface BookRepository extends JpaRepository<BookEntity,Long>{
    //you can customize 
    //you can find by title or author
}
