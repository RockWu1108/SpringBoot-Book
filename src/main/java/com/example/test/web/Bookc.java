package com.example.test.web;


import com.example.test.domin.Book;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v2")
public class Bookc {



    @GetMapping("/book")
    public  Object getBook(){
        return  null;
    }

    @GetMapping("/book/{id}/{buyer:[a-z_]+}")
    public Object getOneBook(@PathVariable("id") long did , @PathVariable String buyer){

        Map<String , Object > books = new HashMap<>();
        books.put("name","SpringBoot");
        books.put("price" , 450);
        books.put("isbn","ssada2312sad");
        books.put("buyer" , buyer);
        return  books;
    }

    @GetMapping("/books")
    public Object getBookList (@RequestParam("size")int size ,
                               @RequestParam(value = "page" ,defaultValue = "2")int page){

        Map<String , Object > books = new HashMap<>();
        books.put("name","SpringBoot");
        books.put("price" , 450);
        books.put("isbn","ssada2312sad");

        Map<String , Object > book2 = new HashMap<>();
        book2.put("name","Java");
        book2.put("price" , 100);
        book2.put("isbn","34325532523");

        List<Map> contents = new ArrayList();
        contents.add(books);
        contents.add(book2);

        Map<String , Object > content = new HashMap<>();
        content.put("size",size);
        content.put("page" ,page);
        content.put("contents",contents);
        System.out.println(content);
        return content;
    }

    @PostMapping("/book")
    public Object postBook(@RequestParam("name") String name ,
                           @RequestParam("author") String author ,
                           @RequestParam("isbn") long isbn){
        Map<String , Object > books = new HashMap<>();
        books.put("name",name);
        books.put("author" , author);
        books.put("isbn",isbn);
        return books;
    }


}
