package com.example.demo.service;

import java.util.List;
import java.util.Map;

import com.example.demo.entity.ProductDTO;

public interface ProductService {
	ProductDTO addProduct(ProductDTO productDto);

	List<ProductDTO> getAllProduct();

	ProductDTO getProductById(Integer id);
	
	Map<String, String> deleteProductById(Integer id);

	ProductDTO updateProduct(ProductDTO productDto, Integer id);
}
