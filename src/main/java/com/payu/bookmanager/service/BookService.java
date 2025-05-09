package com.payu.bookmanager.service;

import com.payu.bookmanager.domain.Book;
import com.payu.bookmanager.repository.BookRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BookService {

    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public List<Book> getAllBooks(){
        return repository.findAll();
    }
}
