package com.example.eshop.entities;


import jakarta.persistence.*;
import lombok.*;

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
@Table(name = "carts")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	//private Integer userId;

	private OffsetDateTime createdAt;
	private OffsetDateTime updatedAt;

//
//	private UserEntity user;

//
//	private IEnumerable<CartItem> CartItems;
}
