package io.sixhours.memecached.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller used to return book information.
 *
 * @author Sasa Bolic
 */
@RestController
public class BookController {

    @Autowired
    private BookRepository repository;

    /**
     * Returns list of {@link Book}.
     *
     * @return the list
     */
    @GetMapping("/books")
    public List<Book> books() {
        return repository.findAll();
    }

    /**
     * Returns list of {@link Book} filtered by title.
     *
     * @param title the title
     * @return the list
     */
    @GetMapping("/books/{title}")
    public List<Book> booksByTitle(@PathVariable String title) {
        return repository.findByTitle(title);
    }


}