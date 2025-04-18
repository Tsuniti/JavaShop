package com.example.eshop.entities;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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
@Table(name = "reviews")
public class Review {

	@PrePersist
	public void prePersist() {

		if(createdAt == null)
			createdAt=OffsetDateTime.now();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull(message = "Rating cannot be null.")
	@Min(value = 1, message = "Rating must be at least 1")
	@Max(value = 5, message = "Rating must be at most 5")
	private int rating;

	@NotNull(message = "Text cannot be null.")
	private String text;


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
	@JoinColumn(name = "product_id", nullable = true,
			foreignKey = @ForeignKey(name = "FK_reviews_product_id_products"))
	private Product product;

	//ManyToOne
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_entity_id", nullable = true,
			foreignKey = @ForeignKey(name = "FK_reviews_user_entity_id_user_entities"))
	private UserEntity userEntity;

}
