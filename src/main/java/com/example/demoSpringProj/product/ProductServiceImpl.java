package com.example.demoSpringProj.product;

import com.example.demoSpringProj.core.ValidationUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    private ProductRepository productRepository;
    private ProductDao productDao;

    public ProductServiceImpl(ProductRepository productRepository, ProductDao productDao) {
        this.productRepository = productRepository;
        this.productDao = productDao;
    }

    @Override
    public Product saveProduct(Product product) throws Exception {
        validateProduct(product);

        return productRepository.save(product);
    }



    @Override
    public List<Product> getProducts(ProductSearchParams params) throws Exception {
        validateSearchParams(params);
        return productDao.getProducts(params);
//        if(ObjectUtils.isEmpty(params.getName())&&ObjectUtils.isEmpty(params.getDescription())) {
//            //user doesnot want any filters wants to see all records
//            //that is name =null& description=null in searchParams
//            return productRepository.findAll();
//        }
//        if(!ObjectUtils.isEmpty(params.getName())&&ObjectUtils.isEmpty(params.getDescription())){
//            //user  wants only name filters
//            //that is name =notnull& description=null in searchParams
//            return  productRepository.findByNameContainsIgnoreCase(params.getName());
//
//        }
//        if(ObjectUtils.isEmpty(params.getName())&&!ObjectUtils.isEmpty(params.getDescription())){
//            //user  wants only description filters
//            //that is name =null& description=NotNull in searchParams
//            return  productRepository.findByDescriptionContainsIgnoreCase(params.getDescription());
//
//        }
//
//            //user  wants both  filters
//            //that is name =NotNull& descriptionNotNull in searchParams
//            return  productRepository.findByNameContainsIgnoreCaseAndDescriptionContainsIgnoreCase( params.getName(),params.getDescription());
//
//
//
   }

    @Override
    public Product getProduct(Long id) {

        Product p= productRepository.findById(id).orElse(null);
        return p;
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }



    private void validateProduct(Product product) throws Exception{
        ValidationUtils.validateProductSize(product.getSize(),true);
        if(ObjectUtils.isEmpty(product.getName())){
            throw new Exception("Name cannot be empty");

        }
        if(ObjectUtils.isEmpty(product.getDescription())){
            throw new Exception("Description cannot be empty");

        }


        if(!product.getName().matches("^[a-zA-Z ]+$")){
            throw new Exception("Name can only contain alphabets");
       }
        if(!product.getDescription().matches("^[a-zA-Z ]+$")){
            throw new Exception("Description can only contain alphabets");
        }



    }
    private void validateSearchParams(ProductSearchParams params) throws Exception {
        ValidationUtils.validateProductSizes(params.getSizes());

    }

}
