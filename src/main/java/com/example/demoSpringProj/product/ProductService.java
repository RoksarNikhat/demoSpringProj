package com.example.demoSpringProj.product;

import java.util.List;

public interface ProductService {
    Product saveProduct(Product product) throws Exception;

    List<Product> getProducts(ProductSearchParams params) throws Exception;

    Product getProduct(Long id);

    void deleteProduct(Long id);

//    List<Product> getProductsWithDescription(ProductSearchParams params);
}
