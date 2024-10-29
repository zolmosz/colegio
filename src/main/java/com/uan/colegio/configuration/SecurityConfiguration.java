package com.uan.colegio.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http
      .requiresChannel(channel -> channel.anyRequest().requiresSecure())
			.authorizeHttpRequests((authorize) -> authorize
                .requestMatchers("/css/**").permitAll()
                .requestMatchers("/img/**").permitAll()
                .requestMatchers("/js/**").permitAll()
                .requestMatchers("/scss/**").permitAll()
                .requestMatchers("/vendor/**").permitAll()
                .requestMatchers("/layout/**").permitAll()
                .requestMatchers("/actuator/**").permitAll()
                .requestMatchers("/inicio").authenticated()
                .requestMatchers("/views/**").authenticated()
                .anyRequest().permitAll()
			)
			.formLogin((form) -> form
                .loginPage("/login")
                .defaultSuccessUrl("/access")
                .permitAll()
			)			
			.logout((logout) -> logout.permitAll());
		return http.build();
		
    }

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
