package com.example.demoSpringProj.product;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@Api(description="Operations related to product")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @ApiOperation(value="Saving Product Detail")
    @PostMapping("/api/save-product")
    public Product saveProduct(@RequestBody Product product) throws Exception{
        try{
            return productService.saveProduct(product);
        } catch (Exception e) {
            log.error("Problem in saving product" ,e);
            throw e;
        }
    }
    @ApiOperation(value="Fetching all products")
    @PostMapping ("/api/products")
    public List<Product> getProducts(@RequestBody ProductSearchParams params) throws Exception {
        try{
            return productService.getProducts(params);
        }
        catch(Exception e){
            log.error("Not able to fetch products",e);
            throw e;

        }

            }


    @ApiOperation(value="Get the product")
    @GetMapping("/api/product/{id}")
    public Product getProduct(@PathVariable  Long id ){
        try{
            return productService.getProduct(id);
        }
        catch(Exception e){
            log.error("Not able to get single product",e);
            throw e;
        }
    }
    @ApiOperation(value="Delete the product")
    @DeleteMapping("/api/delete-product/{id}")
    public void deleteProduct(@PathVariable  Long id){
        try {
            productService.deleteProduct(id);
        }
        catch(Exception e){
            log.error("Not able to delete the product",e);
            throw e;
        }

    }

}
