package com.example.demomongodb.service;

import com.example.demomongodb.dao.ProductRepository;
import com.example.demomongodb.models.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public List<Product> addProduct(Product entity) {
        try {
            Integer maxId = getMaxIdFromProduct();
            if(maxId > 0) {
                entity.setProductId(++maxId);
                productRepository.save(entity);
                return reverseOrderProductRecords();
            } else {
                entity.setProductId(1);
                productRepository.save(entity);
                return reverseOrderProductRecords();
            }
        } catch (Exception ex) {
            System.out.println("Add Exception: "+ex.getMessage());
            log.error("Log error in save Product"+ex.getLocalizedMessage());
            throw new RuntimeException(ex.getLocalizedMessage());
        }
    }

    private Integer getMaxIdFromProduct() {
        return productRepository.findAll().stream()
                .sorted((p1,p2) -> p2.getProductId() - p1.getProductId())
                .map(Product::getProductId)
                .findFirst()
                .get();
    }

    public List<Product> reverseOrderProductRecords() {
        return productRepository.findAll().stream()
                .sorted((p1,p2)-> p2.getProductId() - p1.getProductId())
                .toList();
    }

    public List<Product> updateProduct(Product product) {
        Product record = productRepository.findById(product.getProductId())
                .orElseThrow(
                        ()-> new RuntimeException("Record Not Found by the productId: "+product.getProductId()));

        record.setProductName(product.getProductName());
        record.setProductPrice(product.getProductPrice());
        record.setProductId(product.getProductId());

        productRepository.save(record);
        return reverseOrderProductRecords();
    }

    public List<Product> deleteProduct(Integer productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(
                        ()-> new RuntimeException("Record Not Found by the productId: "+productId));
        productRepository.delete(product);
        return reverseOrderProductRecords();
    }

    public Product getProductbyId(Integer productId) {
        return productRepository.findById(productId)
                .orElseThrow(
                        ()-> new RuntimeException("Record Not Found by the productId: "+productId));
    }
}
