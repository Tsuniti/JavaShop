package com.example.eshop.entities;

import com.example.eshop.data.services.json.CategoryDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

@Builder

@Getter
@Setter
@ToString
@EqualsAndHashCode
//
@NoArgsConstructor
@AllArgsConstructor
//
@Entity
@Table(name = "products")
public class Product {


	@PrePersist
	public void prePersist() {

		if(createdAt == null)
			createdAt=OffsetDateTime.now();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull(message = "Name cannot be null.")
	@Size(min = 3, max = 32, message = "Category name must be between 3 and 32 characters long.")
	private String name;


	@NotNull(message = "Description cannot be null.")
	private String description;


	@NotNull(message = "Price cannot be null.")
	@DecimalMin(value = "0.0", message = "The price cannot be negative")
	@DecimalMax(value = "999999999.0", message = "The price is too large")
	@Digits(integer = 9, fraction = 2, message = "The price must have at most 2 decimal places")
	private BigDecimal price;

	@Min(value = 0, message = "Rating must be at least 0.00")
	@Max(value = 5, message = "Rating must be at most 5.00")
	private double rating;

	@NotNull(message = "Quantity cannot be null.")
	@Min(value = 0, message = "Quantity must be at least 0")
	private Integer quantity;

	//@NotNull(message = "CreatedAt cannot be null.")
	@Column(nullable = false, updatable = false)
	private OffsetDateTime createdAt;
	@Nullable
	private OffsetDateTime updatedAt;




	//Relations
	//OneToOne
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToOne(fetch = FetchType.LAZY)
	private Image image;

	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@JsonDeserialize(using = CategoryDeserializer.class)
	@OneToOne(fetch = FetchType.EAGER)
	private Category category;

	//OneToMany
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = "product",fetch = FetchType.LAZY)
	private List<Review> reviews;

	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = "product",fetch = FetchType.LAZY)
	private List<CartItem> cartItems;




	//todo
//	public void setRating(double rating) {
//		DecimalFormat df = new DecimalFormat("#.##");
//		df.setRoundingMode(RoundingMode.HALF_UP);
//		this.rating = Double.parseDouble(df.format(rating));
//	}


}
