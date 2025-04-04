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
@Table(name = "categories")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	//@Size(min = 3, max = 32, message = "Category name must be between 3 and 32 characters long.")
	private String Name;

	private OffsetDateTime createdAt;
	private OffsetDateTime updatedAt;

//	public IEnumerable<Product> Products { get; set; } = new List<Product>();
}
