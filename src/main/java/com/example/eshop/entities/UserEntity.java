package com.example.eshop.entities;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

import java.time.OffsetDateTime;
import java.util.List;

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

	public enum Status {
		CREATED, ACTIVE, BLOCKED, DELETED
	}
	public enum Role {
		GUEST, USER, MODERATOR, ADMIN
	}

	{
		status = Status.CREATED;
		role = Role.USER;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;


//	@NotNull(message = "Username cannot be null.")
//	@Size(min = 3, max = 32, message = "Username must be between 3 and 32 characters long.")
//	@Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "Username can only contain letters, numbers, and underscores.")
	@Column(nullable = false, unique = true, length = 32)
	private String username; //todo unique

//	@NotNull(message = "PasswordHash cannot be null.")
//	@NotEmpty(message = "PasswordHash cannot be empty")
@Column(nullable = false)
	private String passwordHash;

//	@NotNull(message = "Status cannot be null.")
@Column(nullable = false)
	private Status status;

//	@NotNull(message = "Role cannot be null.")
@Column(nullable = false)

	private Role role;

//	@NotNull(message = "CreatedAt cannot be null.")
@Column(nullable = false)

	private OffsetDateTime createdAt;
	@Nullable
	private OffsetDateTime updatedAt;


	//Relations
	//OneToOne
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToOne(fetch = FetchType.LAZY)
	private Cart cart;

	//OneToMany
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = "userEntity",fetch = FetchType.LAZY)
	private List<Review> reviews;
}
