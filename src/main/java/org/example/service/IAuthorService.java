package org.example.service;

import org.example.model.Author;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IAuthorService {
    List<Author> listHasLastName(String lastName) throws Exception;
    List<Author> listHasFirstNameLike(String firstName) throws Exception;

    List<Author> listHasLastNameAndBookLike(String lastName, String bookTitle) throws Exception;

    List<Author> listPaginationNative(Integer page, Integer size) throws Exception;
}
