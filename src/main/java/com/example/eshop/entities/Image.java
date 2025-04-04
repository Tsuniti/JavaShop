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
@Table(name = "images")
public class Image {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String url;

	private Integer productId;

//	private Product Product;

	private OffsetDateTime createdAt;
	private OffsetDateTime updatedAt;
}
