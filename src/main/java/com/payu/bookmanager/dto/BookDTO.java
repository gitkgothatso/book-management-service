package com.payu.bookmanager.dto;

import com.payu.bookmanager.domain.BookType;
import io.swagger.v3.oas.annotations.media.Schema;
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

    @Schema(example = "123456789")
    private Long isbn;
    @Schema(example = "Effective Java")
    private String name;
    private LocalDate publishedDate;

    @Schema(example = "123.55")
    private BigDecimal price;

    @Schema(example = "EBOOK")
    @Enumerated(EnumType.STRING)
    private BookType bookType;
}