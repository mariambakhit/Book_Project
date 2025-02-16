package com.example.Books.Repository;

import com.example.Books.models.Book;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepo extends JpaRepository<Book,Long> {

    //@EntityGraph(attributePaths = {"author"})
    Optional<Book> findById(Long id);
}
