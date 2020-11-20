package com.example.demoSpringProj.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {
    private ProductServiceImpl productService;

    @Mock
    private ProductRepository productRepositoryMock;
    @Mock
    private ProductDao productDaoMock;

    @BeforeEach
    void setUp() {
        productService = new ProductServiceImpl(productRepositoryMock, productDaoMock);
    }
    @Test
    void shouldSaveProductForValidValues() {

        Product product = new Product(null, "Bluetooth", "AudioSet",6,"M");
        try {
            productService.saveProduct(product);
            verify(productRepositoryMock).save(product);

        } catch (Exception e) {
            fail("Save product cannot throw error for valid input");
        }
    }
    @Test
        void shouldThrowExceptionForEmptyName(){
            Exception e= assertThrows(Exception.class,()->{productService.saveProduct(new Product(null,null,"AudioSet",7,"M"));});
            assertThat(e.getMessage(), equalTo("Name cannot be empty"));
        }

    @Test
    void shouldThrowExceptionForEmptyDescription(){
        Exception e= assertThrows(Exception.class,()->{productService.saveProduct(new Product(null,"Speaker",null,8,"M"));});
        assertThat(e.getMessage(), equalTo("Description cannot be empty"));
    }

    @Test
    void shouldThrowErrorWithInvalidName(){
        Exception e= assertThrows(Exception.class,()->{productService.saveProduct(new Product(null,"Speaker123","AudioSet",6,"M"));});
        assertThat(e.getMessage(), equalTo("Name can only contain alphabets"));
    }
    @Test
    void shouldThrowErrorWithInvalidDescription(){
        Exception e= assertThrows(Exception.class,()->{productService.saveProduct(new Product(null,"Speaker","Audi#4^oSet",9,"M"));});
        assertThat(e.getMessage(), equalTo("Description can only contain alphabets"));
    }
    @Test
    public void shouldGetProductsList() throws Exception {
        productService.getProducts(new ProductSearchParams());
        verify(productRepositoryMock).findAll();
    }
    @Test
    public void shouldGetProductForValidId() {
        Product expected=new Product(1L,"Mobile","Audio",5,"M");
        when(productRepositoryMock.findById(any())).thenReturn( Optional.of(expected));
        Product actual =productService.getProduct(1L);
        assertThat(actual,equalTo(expected));

    }
    @Test
    public void shouldReturnNullProductForInvalidId() {
        when(productRepositoryMock.findById(any())).thenReturn( Optional.empty());
        Product foundProduct =productService.getProduct(10L);
        assertNull(foundProduct);

    }
    @Test
    public void shouldDeleteProduct()  {
        productService.deleteProduct(5L);
        verify(productRepositoryMock).deleteById(5L);
    }
//    @Test
//    void shouldSearchProductWithMatchingName() throws Exception {
//        Product expectedProducts = new Product(null, "Mb", "Communication Media",5,"M");
//        when(productDaoMock.getProducts(any())).thenReturn(expectedProducts);
//        Product product = new Product(null, "Mb", "Communication Media",5,"M");
//        try {
//            Product responseProduct = productRepository.getProduct(product);
//            verify(productDaoMock).getProducts(products);
//            assertThat(responseProduct, equalTo(expectedProduct));
//
//        } catch (Exception e) {
//            fail("Save product should not throw exception for valid input ");
//        }
}



