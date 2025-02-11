package com.example.Books.controller;

import com.example.Books.models.Author;
import com.example.Books.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
public class AuthorController {
    public AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> FindById(@PathVariable Long id){
       return ResponseEntity.ok(authorService.FindById(id));
    }

    @GetMapping("/All authors")
    public ResponseEntity<?> FindAll(){
        return ResponseEntity.ok(authorService.findAll());
    }

    @PostMapping("/insert new author")
    public ResponseEntity<?> insert(@RequestBody Author entity){
        return  ResponseEntity.ok(authorService.insert(entity));
    }

    @PutMapping("/update author")
    public ResponseEntity<?> update(@RequestBody Author author){
        return ResponseEntity.ok(authorService.update(author));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletebyId(@PathVariable Long id){
        authorService.deletebyId(id);
        return ResponseEntity.ok("Author with id "+id+" deleted successfully");
    }
}
