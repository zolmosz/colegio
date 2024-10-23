package com.uan.colegio.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;

import lombok.AllArgsConstructor;

//import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity
@AllArgsConstructor
public class SecurityConfiguration {

//	private static InMemoryUserDetailsManager InMemory;

//	@Bean
//	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//
//		httpSecurity
//			.authorizeHttpRequests((authorize) -> authorize
//									.requestMatchers("/css/**").permitAll()
//									.requestMatchers("/img/**").permitAll()
//									.requestMatchers("/js/**").permitAll()
//									.requestMatchers("/scss/**").permitAll()
//									.requestMatchers("/vendor/**").permitAll()
//									.requestMatchers("/ayuda").permitAll()
//									.requestMatchers("/layout/**").permitAll()
//									.requestMatchers("/inicio").permitAll()
//									.requestMatchers("/views/**").hasAnyRole("ADMIN")
//									.anyRequest().authenticated()
//									)
//			.formLogin(form -> form
//								.loginPage("/login")
//								.loginProcessingUrl("/logginprocess")
//								.defaultSuccessUrl("/inicio", true)
//								.permitAll()
//					)			
//			.logout(logout -> logout
//				.logoutUrl("/logout")				
//				.logoutSuccessUrl("/login?logout").permitAll()
//				.invalidateHttpSession(true)
//				.clearAuthentication(true)
//				.deleteCookies("JSESSIONID")
//				.permitAll())
//			.httpBasic(withDefaults());

//		return httpSecurity.csrf(csrf -> csrf.disable()).httpBasic(Customizer.withDefaults())
//				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//				.formLogin(form -> form.loginPage("/login").loginProcessingUrl("/logginprocess")
//						.defaultSuccessUrl("/inicio", true).permitAll())
//				.logout(logout -> logout
//						.logoutUrl("/logout")
//						.logoutSuccessUrl("/login?logout").permitAll()
//						)
//				.build();
//		return httpSecurity.build();
//		
//	}

//	@Bean
//	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
//		return authenticationConfiguration.getAuthenticationManager();
//	}

//	@Bean
//	public AuthenticationProvider authenticationProvider() {
//		
//		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//		provider.setPasswordEncoder(passwordEncoder());
//		provider.setUserDetailsService(user);

//		return provider;
//		
//	}

//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}

//	@Bean
//	InMemoryUserDetailsManager userDetailService() {
//		
//		UserDetails user1 = User.withDefaultPasswordEncoder()
//								.username("leoram")
//								.password("123456")
//								.build();
//		
//		UserDetails user2 = User.withDefaultPasswordEncoder()
//				.username("andrea")
//				.password("123456")
//				.build();
//		
//		InMemory = new InMemoryUserDetailsManager();
//		
//		InMemory.createUser(user1);
//		InMemory.createUser(user2);
//		
//		return InMemory;
//	}

//	private final UserDetailsService userDetailsService;
//    private final PasswordEncoder passwordEncoder;

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(daoAuthenticationProvider());
//    }
//
//    @Bean
//    public DaoAuthenticationProvider daoAuthenticationProvider() {
//        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//        provider.setUserDetailsService(userDetailsService);
//        provider.setPasswordEncoder(passwordEncoder);
//        return provider;
//    }

}
