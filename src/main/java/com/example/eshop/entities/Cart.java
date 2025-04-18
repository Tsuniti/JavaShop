package com.example.eshop.entities;


import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

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
@Table(name = "carts")
public class Cart {



	@PrePersist
	public void prePersist() {

		if(createdAt == null)
			createdAt=OffsetDateTime.now();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;


	//@NotNull(message = "CreatedAt cannot be null.")
	@Column(nullable = false, updatable = false)
	private OffsetDateTime createdAt;
	@Nullable
	private OffsetDateTime updatedAt;


	//
	//Relations
	//OneToOne
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToOne(mappedBy = "cart", fetch = FetchType.LAZY)
	@JoinColumn(nullable = false)
	private UserEntity userEntity;



	//OneToMany
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = "cart",fetch = FetchType.LAZY)
	private List<CartItem> cartItems;


}
