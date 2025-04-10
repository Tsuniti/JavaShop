package com.example.eshop.entities;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;


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
	@DecimalMax(value = "999_999_999.0", message = "The price is too large")
	@Digits(integer = 1, fraction = 2, message = "The price must have at most 2 decimal places")
	private BigDecimal price;

	@NotNull(message = "Rating cannot be null.")
	@Min(value = 1, message = "Rating must be at least 1.00")
	@Max(value = 5, message = "Rating must be at most 5.00")
	private double rating;

	@NotNull(message = "Quantity cannot be null.")
	@Min(value = 0, message = "Quantity must be at least 1")
	private Integer quantity;

	@NotNull(message = "CreatedAt cannot be null.")
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
	@OneToOne(fetch = FetchType.LAZY)
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
