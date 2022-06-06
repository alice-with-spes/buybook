package com.example.demo.buybook.application;

import com.example.demo.buybook.domain.Product;
import com.example.demo.buybook.domain.ProductRepository;
import com.example.demo.buybook.dto.ProductData;
import com.example.demo.buybook.mapper.ProductMapper;
import com.example.demo.buybook.errors.ProductNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductService {

    private final ProductMapper productMapper;
    private final ProductRepository productRepository;

    public ProductService(
            ProductMapper productMapper,
            ProductRepository productRepository
    ) {
        this.productMapper = productMapper;
        this.productRepository = productRepository;
    }

    public List<Product> getProductList() {
        return productRepository.findAll();
    }

    public Product getProduct(Long id) {
        return findProduct(id);
    }

    public Product createProduct(ProductData productData) {
        Product product = productMapper.productDataToProduct(productData);
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, ProductData productData) {
        Product product = findProduct(id);

        product.changeTitle(productData.getTitle());
        product.changePublisher(productData.getPublisher());

        return product;
    }

    public Product deleteProduct(Long id) {
        Product product = findProduct(id);

        product.destroy();

        return product;
    }

    private Product findProduct(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

}
