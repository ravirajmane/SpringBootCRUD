package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRespository;

import java.util.List;

@Service
public class ProductService {

	@Autowired
	private ProductRespository productRespository;
	
	//get
	public List<Product> getProducts(){
		return productRespository.findAll();
	}
	
	public Product getProductById(int id){
		return productRespository.findById(id).orElse(null);
	}
	
	public Product getProductByName(String name){
		return productRespository.findByName(name);
	}
	
	//post
	public Product saveProduct(Product product) {
		//following method save implementation is given JPARepository class
		return productRespository.save(product);
	}
	
	public List<Product> saveProducts(List<Product> products) {
		return productRespository.saveAll(products);
	}
	
	
	public Product updateProduct(Product product) {
		Product existingProduct=productRespository.findById(product.getId()).orElse(null);
		existingProduct.setName(product.getName());
		existingProduct.setQuantity(product.getQuantity());
		existingProduct.setPrice(product.getPrice());
		return productRespository.save(existingProduct);
	}

	public String deleteProduct(int id) {
		 productRespository.deleteById(id);
			return "Removed  "+id;
		}
	
	
	
}
