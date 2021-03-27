package com.example.test.controller;


import com.example.test.domin.Book;
import com.example.test.service.bookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.BlockingDeque;

@RestController
@RequestMapping("api/v1")

public class bookController {

    @Autowired
    private bookService bookService;

    /**
     * 列出所有書單
     * @return
     */
    @GetMapping("/books")
    public List<Book> getAllBook(){
        return  bookService.findAll();
    }

    @GetMapping("/books/{id}")

    public Book getOneBook(@PathVariable long id){
        return  bookService.fineOne(id);
    }

    @PostMapping("/books")
    public Book postBook(@RequestParam String author,
                         @RequestParam String isbn,
                         @RequestParam String name,
                         @RequestParam String description,
                         @RequestParam int price){

        Book book  = new Book();
        book.setAuthor(author);
        book.setIsbn(isbn);
        book.setName(name);
        book.setPrice(price);
        book.setDescription(description);
        return bookService.saveBook(book);
    }

    @PutMapping("/books")

    public Book  update(@RequestParam long id ,
                        @RequestParam String name,
                        @RequestParam String author,
                        @RequestParam String isbn,
                        @RequestParam String description,
                        @RequestParam int price){

        Book book  = new Book();
        book.setId(id);
        book.setAuthor(author);
        book.setIsbn(isbn);
        book.setName(name);
        book.setPrice(price);
        book.setDescription(description);
        return  bookService.updateBook(book);
    }

    @DeleteMapping("/books/{id}")
    public  void delete(@PathVariable long id){
         bookService.delete(id);
    }

    @PostMapping("/books/by")
    public  List<Book> findAuthor(@RequestParam String author){
        System.out.println(author);
       return bookService.findAuthor(author);
    }

}
