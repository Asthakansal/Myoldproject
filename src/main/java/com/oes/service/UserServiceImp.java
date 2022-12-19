package com.oes.service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oes.entity.DeliveryAgent;
import com.oes.entity.Buy;
import com.oes.entity.Product;
import com.oes.entity.Profile;
import com.oes.entity.Review;
import com.oes.entity.User;
import com.oes.repository.OrderRepository;
import com.oes.repository.ProductRepository;
import com.oes.repository.UserRepository;




@Service
public class UserServiceImp implements UserService{

	@Autowired
	UserRepository userRepository;
	@Autowired
	ProductRepository productRepository;
	
	@Override
	public List<User> getAllUsers() throws Exception {
		// may contains other code like security , loggging , validation 
		
				List<User> allUsers =  userRepository.findAll(); // Note : same as save
				return allUsers;
	}

	@Override
	public List<User> getAllUsers(String role) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByUserName(String username) throws Exception {
		
		User outputUser =  userRepository.getUsersByUsername(username);
		
		if(outputUser == null)
		{
			throw new EntityNotFoundException(username+" not listed in the database");
		}
		else
		{
			return outputUser;
		}
		
	}

	@Override
	public List<User> getUsersConnections(String username) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByUserNameAndRole(String username, String role) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUsersByRole(String role) throws Exception {
		System.out.println(" ---->> Inside Servive Impl role "+role);
		return userRepository.getAllUsersByRole(role);
	}

	
	@Override
	public List<User> getUsersBetweenIds(int range1, int range2) throws Exception {
		return userRepository.getUsersBetweenIds(range1, range2);

	
	}

	@Override
	public User getUserById(int searchedUserId) throws Exception {
		
		 User outputUser = userRepository.getReferenceById(searchedUserId);
		 return outputUser;
		}



	@Override
	public List<Review> getAllReviews(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public User insertUser(User user) throws Exception {
		User savedUser =  userRepository.save(user);  // Note :  save() is already implemented by Spring Data JPA
		if(savedUser != null)
		{
			return savedUser;
		}
		else return null;
	}


	@Override
	@Transactional
	public User addReview(Review review, User User) {

		List<Review> allUserReview = User.getAllReviews();    
		
		if(allUserReview == null)
		{
			allUserReview = new ArrayList<>();
			allUserReview.add(review);
		}
		else
		{
			allUserReview.add(review);
		}
		
		
		User.setAllReviews(allUserReview);
		
		
		return User;
	}


	@Override
	@Transactional
	public User linkProfile(Profile profile, User user) {
		user.setUserProfile(profile);
		return user;
	}

	@Override
	@Transactional
	public User addProduct(Product savedProduct, User savedUser) {
    List<Product> allUserProduct = savedUser.getAllProducts();    
		
		if(allUserProduct == null)
		{
			allUserProduct = new ArrayList<>();
			allUserProduct.add(savedProduct);
		}
		else
		{
			allUserProduct.add(savedProduct);
		}
		
		
		savedUser.setAllProducts(allUserProduct);
		
		
		return savedUser;
	}

	@Override
	public User addOrder(Buy savedOrder, User savedUser) {
		 List<Buy> allUserOrder = savedUser.getAllOrders();    
			
			if(allUserOrder == null)
			{
				allUserOrder = new ArrayList<>();
				allUserOrder.add(savedOrder);
			}
			else
			{
				allUserOrder.add(savedOrder);
			}
			
			
			savedUser.setAllOrders(allUserOrder);
			
			
			return savedUser;
		}

	@Override
	public User addDeliveryAgent(DeliveryAgent savedDeliveryAgent, User savedUser) {
		 List<DeliveryAgent> allUserDeliveryAgent = savedUser.getAllDeliveryAgents();    
			
			if(allUserDeliveryAgent == null)
			{
				allUserDeliveryAgent = new ArrayList<>();
				allUserDeliveryAgent.add(savedDeliveryAgent);
			}
			else
			{
				allUserDeliveryAgent.add(savedDeliveryAgent);
			}
			
			
			savedUser.setAllDeliveryAgents(allUserDeliveryAgent);
			
			
			return savedUser;
		}

	@Override
	@Transactional
	public List<Product> getAllProducts() throws Exception {
			List<Product> allProducts = productRepository.findAll();
			
			return allProducts;
		}

	@Override
	public boolean deleteProductById(int productId) throws Exception {
		productRepository.deleteById(productId);
		return true;
	}
	}


	
