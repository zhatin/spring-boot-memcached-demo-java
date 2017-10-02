package io.sixhours.memecached.demo;

/**
 * Entity containing information about a book.
 *
 * @author Sasa Bolic
 */
public class Book {
    private Integer id;
    private String title;
    private Integer year;

    public Book(Integer id, String title, Integer year) {
        this.id = id;
        this.title = title;
        this.year = year;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }
}
