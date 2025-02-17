package com.example.index24_bookapplication_final.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.index24_bookapplication_final.Entity.BookEntity;
import com.example.index24_bookapplication_final.Model.Book;
import com.example.index24_bookapplication_final.Repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAllBooks() {
        //type conversion from entity to model
        List<BookEntity> bookEntities = bookRepository.findAll();
        List<Book> books = new ArrayList<>();
        for(BookEntity bookEntity:bookEntities){
            Book book = new Book();
            book.setId(bookEntity.getId());
            book.setTitle(bookEntity.getTitle());
            book.setAuthor(bookEntity.getAuthor());
            books.add(book);
        }
        return books;
    }

    @Override
    public Optional<Book> getBookById(Long id) {
        if(bookRepository.findById(id).isPresent()){
            BookEntity bookEntity = bookRepository.findById(id).get();
            Book book = new Book();
            book.setId(bookEntity.getId());
            book.setTitle(bookEntity.getTitle());
            book.setAuthor(bookEntity.getAuthor());
            return Optional.of(book);
        }else{
            return Optional.empty();

        }   
    }
    

    @Override
    public String createBook(Book book) {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setTitle(book.getTitle());
        bookEntity.setAuthor(book.getAuthor());
        bookRepository.save(bookEntity);
        return "Book created successfully";
    }

    @Override
    public String updateBook(Long id, Book book) {
        if(bookRepository.findById(id).isPresent()){
            BookEntity bookEntity = bookRepository.findById(id).get();
            bookEntity.setTitle(book.getTitle()); 
            bookEntity.setAuthor(book.getAuthor());
            bookRepository.save(bookEntity);
            return "Book updated successfully";
            }else{
                return "Book not found";
            }

    }

    @Override
    public String deleteBook(Long id) {
        if(bookRepository.findById(id).isPresent()){
            bookRepository.deleteById(id);
            return "Book deleted successfully";
        }else{
            return "Book not found";
        }
    }
    
}
