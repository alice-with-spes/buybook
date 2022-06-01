package com.example.demo.buybook.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Builder
@Getter
@Setter
public class ProductData {
    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    private String publisher;

    public ProductData() {

    }

    public ProductData(Long id, String title, String publisher) {
        this.id = id;
        this.title = title;
        this.publisher = publisher;
    }

}
