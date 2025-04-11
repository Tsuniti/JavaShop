package com.example.eshop.data.services;

import com.example.eshop.entities.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
	List<Review> findAllByProductId(Integer productId);
	Review save(Review review);
	//int update(Review review);
	void delete(Integer id);
}
