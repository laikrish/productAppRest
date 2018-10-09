package com.capgemini.productapp;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.capgemini.productapp.entity.Product;
import com.capgemini.productapp.repository.ProductRepository;
import com.capgemini.productapp.service.ProductService;
import com.capgemini.productapp.service.impl.ProductServiceImpl;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceControllerTest {
	
	private MockMvc mockMvc;
	
	@Mock
	public ProductRepository productRepository;
	
	@InjectMocks
	public ProductServiceImpl productServiceImpl;
	
	@Before
	public void setUP() {
	MockitoAnnotations.initMocks(this);
	mockMvc = MockMvcBuilders.standaloneSetup(productServiceImpl).build();
	}
	
	@Test
	public void testAddProduct() {
		Product product = new Product(1, "nokia", "phone", 5000);
		when(productRepository.save(product)).thenReturn(product);
		Product addProduct = productServiceImpl.addProduct(product);
		assertEquals(1, addProduct.getProductId());
	}
	
	@Test
	public void testUpdateProduct() {
		Product product = new Product(1, "samsung", "phone", 5000);
		when(productRepository.save(product)).thenReturn(product);
		Product addProduct = productServiceImpl.addProduct(product);
		assertEquals(1, addProduct.getProductId());
	}

     @Test
	public void testdeleteproduct() {
		Product product = new Product(1, "samsung", "phone", 5000);
		productServiceImpl.deleteProduct(product);

	}
	
}