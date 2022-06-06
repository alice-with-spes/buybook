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

    protected Product() {
    }

    @Builder
    public Product(Long id, String title, String publisher) {
        this.id = id;
        this.title = title;
        this.publisher = publisher;
    }

    public void changeTitle(String title) {
        this.title = title;
    }


    public void changePublisher(String publisher) {
        this.publisher = publisher;
    }

    public void destroy() {
        // TODO: soft delete
        // this.deleted = true;
    }
}
