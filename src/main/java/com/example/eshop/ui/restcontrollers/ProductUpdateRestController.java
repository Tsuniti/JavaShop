package com.example.eshop.ui.restcontrollers;

import com.example.eshop.data.services.ProductService;
import com.example.eshop.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;

@RestController
public class ProductUpdateRestController {
	@Autowired
	private ProductService productService;

	@PostMapping("/rest/product-update-form")
	public ResponseEntity<?> productUpdate(@RequestBody Product product){
		try	{
			System.out.println("#########################################################");
			System.err.println(product);
			System.err.println(product.getCategory());

			productService.findById(product.getId()).ifPresent( productDb ->{
				product.setUpdatedAt(OffsetDateTime.now());
				productService.save(product);
			});
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
