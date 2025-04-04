package com.example.eshop.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;


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

//	@Size(min = 3, max = 32, message = "Category name must be between 3 and 32 characters long.")
	private String name;

//	private Image image;
	private Integer imageId;

	private String description;

	//private Integer categoryId;

//	private Category category;

//	@DecimalMin(value = "0.0", message = "The price cannot be negative")
//	@DecimalMax(value = "999999999.0", message = "The price is too large")
//	@Digits(integer = 1, fraction = 2, message = "The price must have at most 2 decimal places")
	private BigDecimal price;

//	@PositiveOrZero(message = "Rating must be at least 0.00")
//	@Max(value = 5, message = "Rating must be at most 5.00")
	private double rating;

//	@Min(value = 0, message = "The quantity cannot be negative")
	private Integer quantity;

	private OffsetDateTime createdAt;
	private OffsetDateTime updatedAt;

//	public IEnumerable<Review> Reviews { get; set; } = new List<Review>();
//
//    [JsonIgnore]
//	public IEnumerable<CartItem> CartItems { get; set; } = new List<CartItem>();




	//todo
//	public void setRating(double rating) {
//		DecimalFormat df = new DecimalFormat("#.##");
//		df.setRoundingMode(RoundingMode.HALF_UP);
//		this.rating = Double.parseDouble(df.format(rating));
//	}


}
