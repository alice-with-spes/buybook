package com.example.demo.buybook.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Builder
@Getter
@Setter
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String publisher;

    public Product(Long id, String title, String publisher) {
        this.id = id;
        this.title = title;
        this.publisher = publisher;
    }

    public Product() {

    }

    public void change(String title, String publisher) {
        this.title = title;
        this.publisher = publisher;
    }
}
