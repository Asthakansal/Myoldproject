package com.oes.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oes.entity.OnlineOrder;
import com.oes.entity.Product;
import com.oes.entity.Review;
import com.oes.repository.ProductRepository;
import com.oes.repository.ReviewRepository;
import com.oes.repository.UserRepository;
@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserService userService;
	
	

	@Override
	public List<Product> getAllProductbyUser(String username) throws Exception {

		User user = (User) userRepository.getUsersByUsername(username);
		
		
		return null;
	}

	
	@Override
	public Product addProduct(Product product) {
		Product savedProduct = productRepository.save(product);
		return savedProduct;
	
	}


	@Override
	public List<Product> getAllProducts() throws Exception {
		List<Product> allproducts =  productRepository.findAll(); // Note : same as save
		return allproducts;
	}


	@Override
	public boolean deleteProductById(int productId) throws Exception {
		userRepository.deleteById(productId);
		return true;
	
	}


	@Override
	public com.oes.entity.User getProductByUserName(String username) {
		// TODO Auto-generated method stub
		return null;
	}


	
	
	
	
	
	
	@Override
	public com.oes.entity.User addProduct(List<Product> allProducts, com.oes.entity.User savedUser) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Product> filterAllProductsByProductName(String productName) throws Exception {
		List<Product> output= userService.getAllProducts().stream().filter((iss)->iss.getProductName().equals(productName)).collect(Collectors.toList());
		return output;
		
	}


	

}