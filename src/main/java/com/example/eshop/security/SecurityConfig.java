package com.example.eshop.security;

import com.example.eshop.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

//Spring 3+
//Security 5.7+
//SecurityConfig
@Configuration
public class SecurityConfig {
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	
	//!!! @Lazy
	@Lazy
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	//1 Авторизація в пам'яті (тестовий варіант)
	//@Bean
	public UserDetailsService userDetailsService() {
		UserDetails admin = User
			 .withUsername("a")
			 .password(passwordEncoder.encode("a"))
			 .authorities(UserEntity.Role.ADMIN.name())
			 .build();
		UserDetails user = User
			 .withUsername("u")
			 .password(passwordEncoder.encode("u"))
			 .authorities(UserEntity.Role.USER.name())
			 .build();
		return new InMemoryUserDetailsManager(admin, user);
	}
	
	//Безпека, дозволи, переходи
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
		return security
			 /*.headers(headers -> headers
				  // Вимикає кешування
				  .cacheControl(cache -> cache.disable())
			 )*/
			 //Налаштування дозволених адрес
			 .authorizeHttpRequests(request ->
				  request
						//Дозволені сторінки .permitAll()
						.requestMatchers("/", "/error", "/welcome", "/register", "/register-form", "/*.css").permitAll()
						//Дозволені сторінки залежно від повноважень
						//функції .has...()
						.requestMatchers("/users", "/products", "/categories").hasAuthority(
							 UserEntity.Role.ADMIN.name()
						)
						//Дозволити запити автентифікованих користувачів
						.anyRequest().authenticated()
			 )
			 //Встановлення і дозвіл для стандартної сторінки авторизації
			 .formLogin(formLogin ->
				  formLogin
						.successForwardUrl("/")
						.permitAll()
			 )
			 //Встановлення і дозвіл для стандартної адреси і сторінки виходу
			 //адреса /logout
			 .logout(logoutConfigurer ->
				  logoutConfigurer
						//.logoutSuccessUrl("/welcome")
						.logoutSuccessUrl("/")
						.permitAll()
			 )
			 //+++
			 //Встановлення власної сторінки авторизації
			 //по адресі /authorization
			 /*.formLogin(formLoginConfigurer ->
				  formLoginConfigurer
						.loginPage("/authorization").permitAll()
			 )*/
			 //Встановлення власної сторінки виходу
			 /*.logout(logoutConfigurer ->
				  logoutConfigurer
						.logoutUrl("/logoutown").permitAll()
			 )*/
			 //
		    //Створення об'єкту SecurityFilterChain
			 .build();
	}
}
