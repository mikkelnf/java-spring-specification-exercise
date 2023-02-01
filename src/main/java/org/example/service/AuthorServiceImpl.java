package org.example.service;

import org.example.model.Author;
import org.example.repository.AuthorRepository;
import org.example.repository.AuthorSpecifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements IAuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private AuthorSpecifications authorSpecifications;

    @Override
    public List<Author> listHasLastName(String lastName) throws Exception {
        List<Author> authors = authorRepository.findAll(authorSpecifications.hasLastName(lastName));

        return authors;
    }

    @Override
    public List<Author> listHasFirstNameLike(String firstName) throws Exception {
        List<Author> authors = authorRepository.findAll(authorSpecifications.hasFirstNameLike(firstName));

        return authors;
    }

    @Override
    public List<Author> listHasLastNameAndBookLike(String lastName, String bookTitle) throws Exception {
        List<Author> authors = authorRepository.findAll(authorSpecifications.hasLastName(lastName).
                and(authorSpecifications.hasBookWithTitle(bookTitle)));

        return authors;
    }

    @Override
    public List<Author> listPaginationNative(Integer page, Integer size) throws Exception {
        Integer offset = (page - 1) * size;

        List<Author> authors = authorRepository.findAllNative(size, offset);

        return authors;
    }
}
