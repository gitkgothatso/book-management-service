package com.payu.bookmanager.dto;

import com.payu.bookmanager.domain.BookType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;


import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
    private Long isbn;
    private String name;
    private LocalDate publishedDate;
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    private BookType bookType;
}