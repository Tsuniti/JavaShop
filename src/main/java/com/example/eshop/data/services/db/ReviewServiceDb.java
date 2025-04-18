package com.example.eshop.data.services.db;

import com.example.eshop.data.repositories.ReviewRepository;
import com.example.eshop.data.services.ReviewService;
import com.example.eshop.entities.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceDb implements ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;

	@Override
	public List<Review> findAllByProductId(Integer productId) {
		return reviewRepository.findByProduct_Id(productId);
	}

	@Override
	public Review save(Review review) {
		Review result = reviewRepository.save(review);
		//productRepository.recountRating()
		return result;

	}


	@Override
	public void delete(int id) {
		reviewRepository.deleteById(id);
		//productRepository.recountRating()

	}
}
