package com.example.eshop.entities;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
@Table(name = "images")
public class Image {

	@PrePersist
	public void prePersist() {

		if(createdAt == null)
			createdAt=OffsetDateTime.now();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull(message = "CreatedAt cannot be null.")
	@NotEmpty(message = "CreatedAt cannot be empty.")
	private String url;


	//@NotNull(message = "CreatedAt cannot be null.")
	@Column(nullable = false, updatable = false)
	private OffsetDateTime createdAt;
	@Nullable
	private OffsetDateTime updatedAt;

	//Relations
	//OneToOne
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToOne(mappedBy = "image", fetch = FetchType.LAZY)
	private Product Product;

}
