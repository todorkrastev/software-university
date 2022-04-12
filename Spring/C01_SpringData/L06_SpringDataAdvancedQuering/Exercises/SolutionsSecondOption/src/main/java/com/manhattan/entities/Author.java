package com.manhattan.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="authors")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "udp_get_books_count_by_author",
                procedureName = "udp_get_books_count_by_author",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "first_name", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "last_name", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "count_out", type = Integer.class)
                })
})
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @OneToMany(targetEntity = Book.class, mappedBy = "author", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<Book> books;

    public Author() {
        this.books = new HashSet<>();
    }

    public Author(String firstName, String lastName) {
        this();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return id == author.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
