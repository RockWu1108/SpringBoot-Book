package com.example.test.service;


import com.example.test.domin.Book;
import com.example.test.domin.bookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class bookService {

    @Autowired
    private bookRepository bookRepository;

    public List<Book> findAll(){
        return  bookRepository.findAll();
    }

    public Book fineOne(long id){
        return bookRepository.findById(id).get();
    }

    public Book saveBook(Book book){
        return bookRepository.save(book);
    }

    public Book updateBook(Book book){
        return  bookRepository.save(book);
    }
    public void delete(long id){
        bookRepository.deleteById(id);
    }

    public List<Book> findAuthor(String author){
        return  bookRepository.findByAuthor(author);
    }
    public List<Book> findByPrice(int price){
        return  bookRepository.findByPrice(price);
    }
    public int updateByPrice(int price , long id){
        return bookRepository.updateByPrice(price,id);
    }
}
