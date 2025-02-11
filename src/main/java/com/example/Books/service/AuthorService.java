package com.example.Books.service;

import com.example.Books.Repository.AuthorRepo;
import com.example.Books.models.Author;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    public AuthorRepo authorRepo;

    public AuthorService(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }


    public Author FindById(Long id){
        return authorRepo.findById(id).orElseThrow();
    }

    public List<Author> findAll(){
        return authorRepo.findAll();
    }

    public Author insert(Author entity){
        return authorRepo.save(entity);
    }

    public Author update(Author entity){
        Author author = FindById(entity.getId());
        author.setName(entity.getName());
        return authorRepo.save(entity);
    }

    public void deletebyId(Long id){
        if(!authorRepo.existsById(id)){
            throw new IllegalArgumentException("author with id "+ id +"not found");
        }
         authorRepo.deleteById(id);
    }
}
