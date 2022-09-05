package com.wanderer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomUserDetailsService userDetailsService;
	@Autowired
	private JwtFilter jwtFilter;

	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}
	


	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Bean(name = BeanIds.AUTHENTICATION_MANAGER)
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.cors().disable()
		.authorizeRequests()
		.antMatchers("/user/authenticate","/user/","/packages/**").permitAll()
//		.antMatchers("/order/dispatch/**","/order/deliver/**").hasAuthority("admin")
//		.antMatchers("/cart/**","order/place/**","order/cancel/**").hasAuthority("user")
//		.antMatchers("order/{userId}","/products/**").hasAnyAuthority("admin","user")
		.anyRequest().authenticated()
				.and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
//		 http.cors().configurationSource(new CorsConfigurationSource() {
//	            @Override
//	            public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
//	                CorsConfiguration config = new CorsConfiguration();
//	                config.setAllowedHeaders(Collections.singletonList("*"));
//	                config.setAllowedMethods(Collections.singletonList("*"));
//	                config.addAllowedOrigin("http://localhost:3000");
//	                config.setAllowCredentials(true);
//	                return config;
//	            }
//	          });
	}
}