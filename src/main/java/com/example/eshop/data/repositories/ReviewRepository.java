package com.example.eshop.data.repositories;

import com.example.eshop.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
	List<Review> findByProduct_Id(Integer id);

}