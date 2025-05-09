package com.payu.bookmanager.rest;


import com.payu.bookmanager.domain.Book;
import com.payu.bookmanager.dto.BookDTO;
import com.payu.bookmanager.repository.BookRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookRepository repository;

    public BookController(BookRepository repository) {
        this.repository = repository;
    }

    private BookDTO toDTO(Book book) {
        return new BookDTO(
                book.getIsbn(),
                book.getName(),
                book.getPublishedDate(),
                book.getPrice(),
                book.getType()
        );
    }

    private Book fromDTO(BookDTO dto) {
        return new Book(
                0,
                dto.getIsbn(),
                dto.getName(),
                dto.getPublishedDate(),
                dto.getPrice(),
                dto.getBookType()
        );
    }

    @GetMapping
    public List<BookDTO> getAllBooks() {
        return repository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<BookDTO> getBook(@PathVariable Long isbn) {
        return repository.findByIsbn(isbn)
                .map(this::toDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public BookDTO createBook(@RequestBody BookDTO bookDTO) {
        Book book = fromDTO(bookDTO);
        return toDTO(repository.save(book));
    }

    @PutMapping("/{isbn}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable Long isbn, @RequestBody BookDTO updatedDTO) {
        return repository.findByIsbn(isbn).map(book -> {
            book.setName(updatedDTO.getName());
            book.setPublishedDate(updatedDTO.getPublishedDate());
            book.setPrice(updatedDTO.getPrice());
            book.setType(updatedDTO.getBookType());
            return ResponseEntity.ok(toDTO(repository.save(book)));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{isbn}")
    public ResponseEntity<?> deleteBook(@PathVariable Long isbn) {

        Optional<Book> existingBook = repository.findByIsbn(isbn);
        if (!existingBook.isPresent()) return ResponseEntity.notFound().build();
        repository.deleteById(existingBook.get().getId());
        return ResponseEntity.ok().build();
    }
}