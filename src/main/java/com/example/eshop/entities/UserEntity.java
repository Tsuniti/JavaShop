package com.example.eshop.entities;

import com.example.eshop.enums.UserRole;
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
@Table(name = "userEntities")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;


//	@NotNull(message = "Username cannot be null.")
//	@Min(value = 3, message = "Username must be at least 3 characters long.")
//	@Max(value = 32, message = "Username cannot exceed 32 characters.")
//	@Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "Username can only contain letters, numbers, and underscores.")
	private String username;

	private String passwordHash;

	private UserRole role;

	//private int cartId;
	//private Cart cart;

	//@JsonIgnore
	//private List<Review> reviews = new ArrayList<>();

	private OffsetDateTime createdAt;
	private OffsetDateTime updatedAt;
}
