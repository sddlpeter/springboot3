package com.powernode.problem.controller;

import com.powernode.problem.config.BookContainer;
import com.powernode.problem.exception.BookNotFoundException;
import com.powernode.problem.exception.IsbnNotFoundException;
import com.powernode.problem.model.BookRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Book;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    private BookContainer bookContainer;

    @GetMapping("/book")
    public BookRecord getBook(String isbn) {
        Optional<BookRecord> bookRecord = bookContainer.getBooks().stream().filter(el -> el.isbn().equals(isbn)).findFirst();
        if (bookRecord.isEmpty()) {
            // throw new BookNotFoundException(" isbn: " + isbn + "-> 没有此图书");
            throw new IsbnNotFoundException(HttpStatus.NOT_FOUND, "====isbn: " + isbn + "-> 没有此图书");
        }
        return bookRecord.get();
    }

}
