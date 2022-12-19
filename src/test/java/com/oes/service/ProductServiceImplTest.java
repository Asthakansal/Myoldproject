package com.oes.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.oes.entity.Product;
import com.oes.repository.ProductRepository;
@SpringBootTest
class ProductServiceImplTest {
	@Mock
	ProductRepository  productrepository;
	
	@InjectMocks
    ProductServiceImpl productservice;

	@Test
	@Disabled
	void testGetAllProductbyUser() {
		fail("Not yet implemented");
	}

	@Test
	@DisplayName("Test - to verify the insert operation")
	//@Disabled
	void testAddProductProduct() {
		
		
			// given
			Product sampleInput = new Product("Mobile",8000 , "vivo", "Electronic", "11-12-2022");
			Product expectedOutput = new Product("Laptop",80000 ,"HP", "Electronic", "10-12-2022");
					//Object obj = new Object();
			
			BDDMockito.given(productservice.addProduct(sampleInput)).willReturn(expectedOutput);	
					// when 
			Product actualOutput = productservice.addProduct(sampleInput);
					
					// verify 
					assertEquals(expectedOutput, actualOutput);
				}
	

	@Test
	@Disabled
	void testGetAllProducts() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testDeleteProductById() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testGetProductByUserName() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testAddProductListOfProductUser() {
		fail("Not yet implemented");
	}

}
