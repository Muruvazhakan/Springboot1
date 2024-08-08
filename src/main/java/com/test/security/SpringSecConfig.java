package com.test.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecConfig {

		@Bean
		public SecurityFilterChain filerChain(HttpSecurity http) throws Exception {
			
			//1. All req is authenticated
			
			http.authorizeHttpRequests(
					auth-> auth.anyRequest().authenticated());
			
			// 2. if a req is not authenticated, web page is show
			http.httpBasic(withDefaults());
			
			// 3. CSRF-> POST, PUT
			http.csrf().disable();
			
			return http.build();
		}

}
