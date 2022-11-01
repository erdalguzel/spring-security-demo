package dev.springsecurity.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

import dev.springsecurity.demo.enumeration.UserRole;

@Configuration
@EnableWebSecurity
public class WebAppSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		UserBuilder userBuilder = User.withDefaultPasswordEncoder();

		auth.inMemoryAuthentication()
				.withUser(userBuilder.username("john").password("test123").roles(UserRole.EMPLOYEE.getKey()))
				.withUser(userBuilder.username("mary").password("test123").roles(UserRole.ADMIN.getKey()))
				.withUser(userBuilder.username("karen").password("test123").roles(UserRole.MANAGER.getKey()));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.anyRequest()
		.authenticated()
		.and()
		.formLogin()
		.loginPage("/login")
		.loginProcessingUrl("/authenticate")
		.permitAll();
	}

}
