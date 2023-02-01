package org.example.repository;

import org.example.model.Author;
import org.example.model.Book;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.Join;

@Component
public class AuthorSpecifications {
    public Specification<Author> hasFirstNameLike(String name) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.<String>get("firstName"), "%" + name + "%");
    }

    public Specification<Author> hasLastName(String name) {
        return (root, query, cb) ->
                cb.equal(root.<String>get("lastName"), name);
    }

    public Specification<Author> hasBookWithTitle(String bookTitle) {
        return (root, query, criteriaBuilder) -> {
            Join<Book, Author> authorsBook = root.join("books");
            return criteriaBuilder.equal(authorsBook.get("title"), bookTitle);
        };
    }
}
