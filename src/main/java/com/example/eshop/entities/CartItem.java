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
@Table(name = "cartItems")
public class CartItem {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Integer Quantity;

	//private Integer ProductId;
	//private Integer CartId;


	private OffsetDateTime createdAt;
	private OffsetDateTime updatedAt;
}
