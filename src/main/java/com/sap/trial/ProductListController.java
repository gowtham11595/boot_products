package com.sap.trial;

import java.util.Collection;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("products")
public class ProductListController {
	
	private final ProductRepository productRepository;
	
	public ProductListController(ProductRepository productRepository){
	this.productRepository = productRepository;	
	}
	
	@GetMapping
	public Collection<Product> getAllProducts() {
		return productRepository.findAll(0, Integer.MAX_VALUE);
	}
	
	@GetMapping(path = "{id}")
	public Product getProductById(@PathVariable("id") String id) {
		System.out.println("came in");
		return productRepository.find(id);
	}

	@PostMapping
//	@RequestMapping(consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> createProduct(@RequestBody Product newproduct) {
		System.out.println(newproduct);
		productRepository.add(newproduct);
		HttpHeaders headers = new HttpHeaders();
		headers.setETag(String.format("\"%d\"", 0));
		headers.setLocation(
				ServletUriComponentsBuilder.fromCurrentRequest().path("/" + newproduct.getProductId()).build().toUri());
		ResponseEntity<Product> response = new ResponseEntity<>(newproduct, headers, HttpStatus.CREATED);
		return response;
	}

	@RequestMapping(path = "{id}", method = RequestMethod.HEAD)
	public ResponseEntity<?> existsProduct(@PathVariable("id") String id) {
		ResponseEntity<?> response = null;

			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ServletUriComponentsBuilder.fromCurrentRequest().path("/" + id).build().toUri());
			response = new ResponseEntity<>(null, headers, HttpStatus.NO_CONTENT);
			
		
		return response;
	}
	
	
}
