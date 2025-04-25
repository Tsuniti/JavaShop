package com.example.eshop.entities;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.*;

import java.time.OffsetDateTime;

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
@Table(name = "cartItems",
uniqueConstraints = @UniqueConstraint(columnNames = {"product_id", "cart_id"}))
public class CartItem {

	@PrePersist
	public void prePersist() {

		if(createdAt == null)
			createdAt=OffsetDateTime.now();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "Quantity cannot be null.")
	@Min(value = 0, message = "Quantity must be at least 1")
	private int quantity;


	//@NotNull(message = "CreatedAt cannot be null.")
	@Column(nullable = false, updatable = false)
	private OffsetDateTime createdAt;
	@Nullable
	private OffsetDateTime updatedAt;

	//Relations
	//ManyToOne
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id", nullable = true,
			foreignKey = @ForeignKey(name = "FK_cart_items_products"))
	private Product product;

	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cart_id", nullable = true,
			foreignKey = @ForeignKey(name = "FK_cart_items_carts"))

	private Cart cart;
}
