package com.example.demo.buybook;

import com.example.demo.buybook.mapper.ProductMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BuybookApplication {

    public static void main(String[] args) {
        SpringApplication.run(BuybookApplication.class, args);
    }

    @Bean
    public ProductMapper productMapper() {
        return Mappers.getMapper(ProductMapper.class);
    }

}
