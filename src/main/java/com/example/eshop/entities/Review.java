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
@Table(name = "reviews")
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Integer rating;
	private String text;

	//private Integer userId;
	//private User User;

	//public int ProductId;
    //@JsonIgnore
	//public Product Product;

	private OffsetDateTime createdAt;
	private OffsetDateTime updatedAt;
}
