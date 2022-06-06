package com.example.demo.buybook.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@Builder
@Getter
@Setter
public class ProductData {
    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    private String publisher;

    public ProductData(Long id, String title, String publisher) {
        this.id = id;
        this.title = title;
        this.publisher = publisher;
    }

}
