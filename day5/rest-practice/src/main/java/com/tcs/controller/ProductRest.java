package com.tcs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.beans.Product;
import com.tcs.service.ProductService;

@RestController
@RequestMapping("product")
public class ProductRest {

	@Autowired
	private ProductService service;
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Product saveProduct(@RequestBody Product product) {
		return service.store(product);
	}
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Product> getProducts() {
		return service.fetchProducts();
	}

	@GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Product findProduct(@PathVariable("id") int productId) {
		return service.fetchProductById(productId);
	}
	
	@PutMapping(path = "{id}/{price}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Product updateProductPrice(@PathVariable("id") int id, @PathVariable("price") double price) {
		return service.updateProductPrice(id, price);
	}
	@DeleteMapping(path = "{id}")
	public String deleteProduct(@PathVariable("id") int id) {
		service.deleteProductById(id);
		return "Product deletion";
	}
}
