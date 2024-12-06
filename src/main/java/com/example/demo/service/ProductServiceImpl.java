package com.example.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.entity.ProductDTO;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepo;

	@Override
    public ProductDTO addProduct(ProductDTO productDto) {
        Product product = mapToEntity(productDto);
        return mapToDto(productRepo.save(product));
    }

	 @Override
	    public List<ProductDTO> getAllProduct() {
	        List<Product> products = productRepo.findAll();
	        return products.stream()
	                .map(this::mapToDto)
	                .collect(Collectors.toList());
	    }

	 @Override
	    public ProductDTO getProductById(Integer id) {
	        Product product = productRepo.findById(id)
	                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
	        return mapToDto(product);
	    }

	    @Override
	    public ProductDTO updateProduct(ProductDTO productDto, Integer id) {
	        Product existingProduct = productRepo.findById(id)
	                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));

	        existingProduct.setName(productDto.getName());
	        existingProduct.setDescr(productDto.getDescr());

	        Product updatedProduct = productRepo.save(existingProduct);
	        return mapToDto(updatedProduct);
	    }

	    @Override
	    public Map<String, String> deleteProductById(Integer id) {
	        Product product = productRepo.findById(id)
	                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
	        productRepo.delete(product);

	        Map<String, String> response = new HashMap<>();
	        response.put("message", "Product deleted successfully");
	        return response;
	    }

	private ProductDTO mapToDto(Product product) {
		ProductDTO productDto = new ProductDTO();
		productDto.setId(product.getId());
		productDto.setName(product.getName());
		productDto.setDescr(product.getDescr());
		return productDto;
	}

	private Product mapToEntity(ProductDTO productDto) {
		Product product = new Product();
		product.setId(productDto.getId());
		product.setName(productDto.getName());
		product.setDescr(productDto.getDescr());
		return product;
	}

}
