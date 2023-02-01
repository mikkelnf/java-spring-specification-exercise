package org.example.controller;

import org.example.model.Author;
import org.example.model.responses.SuccessResponse;
import org.example.service.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    IAuthorService authorService;

//    @GetMapping(params = {"page", "size", "orderBy"})
    @GetMapping
    public ResponseEntity getAllPaginationNative(@RequestParam(defaultValue = "1") Integer page,
                                                 @RequestParam(defaultValue = "1") Integer size) throws Exception{
        List<Author> listHasFirstNameLike = authorService.listPaginationNative(page, size);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse("Success", listHasFirstNameLike));
    }

    @GetMapping(params = {"lastName"})
//    @GetMapping()
    public ResponseEntity getAllHasLastName(@RequestParam String lastName) throws Exception{
        List<Author> listHasLastName = authorService.listHasLastName(lastName);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse("Success", listHasLastName));
    }

    @GetMapping(params = {"firstName"})
    public ResponseEntity getAllHasFirstNameLike(@RequestParam String firstName) throws Exception{
        List<Author> listHasFirstNameLike = authorService.listHasFirstNameLike(firstName);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse("Success", listHasFirstNameLike));
    }

    @GetMapping(params = {"lastName", "bookTitle"})
    public ResponseEntity getAllHasLastNameLikeAndBookTitle(@RequestParam String lastName, @RequestParam String bookTitle) throws Exception{
        List<Author> listHasLastNameLikeAndBookTitle = authorService.listHasLastNameAndBookLike(lastName, bookTitle);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse("Success", listHasLastNameLikeAndBookTitle));
    }
}
