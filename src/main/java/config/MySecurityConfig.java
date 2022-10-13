package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class MySecurityConfig{
	
	@Bean
	public UserDetailsService getUserDetailsService() {
		return new UserDetailsServiceImplementation();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
	    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	    
	    authProvider.setUserDetailsService(this.getUserDetailsService());
	    authProvider.setPasswordEncoder(this.passwordEncoder());
	   
	    return authProvider;
	}
	
	  @Bean
	  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		  System.out.print("fajsbhcvsbahcbashbcjkasnsjklnkclsnak");
		  http
		  		.csrf().disable()
		  		.cors()
				.disable()
		  		.authorizeRequests()
		  		.antMatchers("/**", "/api/**").permitAll()
		  		.antMatchers(HttpMethod.OPTIONS).permitAll()
		  		.anyRequest()
		  		.authenticated()
		  		.and()
		  		.httpBasic();
		  
	      http.authenticationProvider(this.authenticationProvider());
	    
	      return http.build();
	}
}
