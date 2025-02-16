package com.example.Books.service;

import com.example.Books.Repository.AuthorRepo;
import com.example.Books.Repository.BookRepo;
import com.example.Books.models.Author;
import com.example.Books.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    public BookRepo bookRepo;

    @Autowired
    public AuthorService authorService;

    @Autowired
    public AuthorRepo authorRepo;

    public Book findByID(Long id){
        return bookRepo.findById(id).orElseThrow();
    }

    public List<Book> findAll(){
        return bookRepo.findAll();
    }

    public Book insert(Book book){
        Author author = authorRepo.findById(book.getAuthor().getId())
                .orElseThrow(() -> new RuntimeException("Author not found"));

        Book newbook = new Book();
        book.setName(book.getName());
        book.setPrice(book.getPrice());
        book.setAuthor(author); // Set Author object

        return bookRepo.save(book);
    }

    public Book update(Book book) {
        // Find the existing book by its ID
        Book existingBook = findByID(book.getId());
        if (existingBook == null) {
            throw new IllegalArgumentException("Book with ID " + book.getId() + " not found.");
        }

        // Update book's basic attributes
        existingBook.setName(book.getName());
        existingBook.setPrice(book.getPrice());

        // Update the book's author if a valid author ID is provided
        if (book.getAuthor() != null && book.getAuthor().getId() != null) {
            Long authorId = book.getAuthor().getId();

            // Check if the author exists
            if (!authorRepo.existsById(authorId)) {
                throw new IllegalArgumentException("Author with ID " + authorId + " not found.");
            }

            // Set the new author
            Author updatedAuthor = authorService.FindById(authorId);
            existingBook.setAuthor(updatedAuthor);
        }

        // Save and return the updated book
        return bookRepo.save(existingBook);
    }


    public void deleteById(Long id){
        if(!bookRepo.existsById(id)){
            throw new IllegalArgumentException("this book of id "+id+"isn't exist");
        }
        bookRepo.deleteById(id);
    }

}
