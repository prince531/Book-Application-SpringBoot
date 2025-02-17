package com.example.index24_bookapplication_final.Service;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.index24_bookapplication_final.Model.Book;
@Service
public interface BookService {
    List<Book> getAllBooks();
    Optional<Book> getBookById(Long id);
    String createBook(Book book);
    String updateBook(Long id, Book book);
    String deleteBook(Long id);
    
}

