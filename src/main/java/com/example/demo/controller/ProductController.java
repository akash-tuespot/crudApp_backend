package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.ProductDTO;
import com.example.demo.service.ProductService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/products")
	public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO productDto) {
		ProductDTO insertedproduct = productService.addProduct(productDto);
		return ResponseEntity.ok(insertedproduct);
	}

	@GetMapping("/products")
	public ResponseEntity<List<ProductDTO>> getAllProducts() {
		List<ProductDTO> products = productService.getAllProduct();
		return ResponseEntity.ok(products);
	}

	@GetMapping("/products/{id}")
	public ResponseEntity<ProductDTO> getProductById(@PathVariable Integer id) {
		ProductDTO product = productService.getProductById(id);
		return ResponseEntity.ok(product);
	}

	@DeleteMapping("/products/{id}")
	public ResponseEntity<Map<String, String>> deleteProductById(@PathVariable Integer id) {
		Map<String, String> response = productService.deleteProductById(id);
		return ResponseEntity.ok(response);
	}

	@PutMapping("/products/{id}")
	public ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductDTO productDto, @PathVariable Integer id) {
		ProductDTO updatedProduct = productService.updateProduct(productDto, id);
		return ResponseEntity.ok(updatedProduct);
	}

}
