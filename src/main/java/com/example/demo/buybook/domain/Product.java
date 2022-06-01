package com.example.demo.buybook.domain;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    private String publisher;

    @Builder
    public Product(Long id, String title, String publisher) {
        this.id = id;
        this.title = title;
        this.publisher = publisher;
    }

    protected Product() {

    }

    public void change(String title, String publisher) {
        this.title = title;
        this.publisher = publisher;
    }
}
