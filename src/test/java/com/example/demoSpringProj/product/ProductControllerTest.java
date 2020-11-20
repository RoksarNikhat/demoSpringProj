package com.example.demoSpringProj.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {
    private ProductController productController;
    @Mock
    private ProductService productServiceMock;

    @BeforeEach
    void setUp() {
        productController = new ProductController(productServiceMock);
    }

    @Test
    void shouldSaveProductWithValidInput() throws Exception {
        Product expectedProduct = new Product(null, "Mobile", "Communication Media",5,"M");
        when(productServiceMock.saveProduct(any())).thenReturn(expectedProduct);
        Product product = new Product(null, "Mobile", "Communication Media",5,"M");
        try {
            Product responseProduct = productController.saveProduct(product);
            verify(productServiceMock).saveProduct(product);
            assertThat(responseProduct, equalTo(expectedProduct));

        } catch (Exception e) {
            fail("Save product should not throw exception for valid input ");
        }
    }

    @Test
    void shouldThrowException() throws Exception {

        when(productServiceMock.saveProduct(any())).thenThrow(new RuntimeException("New Exception"));
        Exception e = assertThrows(RuntimeException.class, () -> {
            productController.saveProduct(null);
        });
        assertThat(e.getMessage(), equalTo("New Exception"));
    }
}