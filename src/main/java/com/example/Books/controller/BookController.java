package com.example.Books.controller;

import com.example.Books.models.Book;
import com.example.Books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    public BookService bookService;

    @GetMapping("/{id}")
    public ResponseEntity<?> FindByID(@PathVariable Long id){
        return ResponseEntity.ok(bookService.findByID(id));
    }

    @GetMapping("/find all Books")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(bookService.findAll());
    }

    @PostMapping("/insert new book")
    public ResponseEntity<?> insert(@RequestBody Book book){
        return ResponseEntity.ok(bookService.insert(book));
    }

    @PutMapping("/update book")
    public ResponseEntity<?> update(@RequestBody Book book){
        return ResponseEntity.ok(bookService.update(book));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        return ResponseEntity.ok("this book of id "+ id + " is deleted successfully");
    }


}
