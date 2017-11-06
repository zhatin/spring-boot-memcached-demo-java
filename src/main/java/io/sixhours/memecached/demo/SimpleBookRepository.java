package io.sixhours.memecached.demo;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of {@link BookRepository} containing mocked data.
 *
 * @author Sasa Bolic
 */
@Repository
public class SimpleBookRepository implements BookRepository {
    private List<Book> books = List.of(
            new Book(1, "Kotlin in Action", 2017),
            new Book(2, "Spring Boot in Action", 2016),
            new Book(3, "Programming Kotlin", 2017),
            new Book(4, "Kotlin", 2017));

    @Override
    public List<Book> findAll() {
        return this.books;
    }

    @Override
    @Cacheable("books")
    public List<Book> findByTitle(String title) {
        simulateSlowService();
        return books.stream().filter(b -> b.getTitle().equals(title)).collect(Collectors.toList());
    }

    @Override
    @CacheEvict(value = "books", allEntries = true, beforeInvocation = true)
    @Cacheable("books")
    public List<Book> evictAndRecache() {
        return this.books;
    }

    private void simulateSlowService() {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
