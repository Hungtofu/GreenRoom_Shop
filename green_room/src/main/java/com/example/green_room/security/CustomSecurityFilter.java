package com.example.green_room.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class CustomSecurityFilter {

    @Autowired
    CustomUserDetailService customUserDetailService;

    @Autowired
    CustomJwtFilter customJwtFilter;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity httpSecurity) throws Exception{

        AuthenticationManagerBuilder authenticationManagerBuilder = httpSecurity.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(customUserDetailService);

        return authenticationManagerBuilder.build();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(httpSecuritySessionManagementConfigurer ->
                        httpSecuritySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(
                        request -> request
                                .requestMatchers("/login/**").permitAll()
                                .requestMatchers("/file/**").permitAll()
                                .requestMatchers("/plantType/**").permitAll()
                                .requestMatchers("/size/**").permitAll()
                                .requestMatchers("/potType/**").permitAll()
                                .requestMatchers("/plant/**").permitAll()
                                .requestMatchers("/order/**").permitAll()
                                .requestMatchers("/orderItem/**").permitAll()
                                .requestMatchers("/cart/**").permitAll()
                                .requestMatchers("/cartItem/**").permitAll()
                                .requestMatchers("/image/**").permitAll()
                                .requestMatchers("/product/**").permitAll()
                                .anyRequest().authenticated()
                );


        http.addFilterBefore(customJwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }




}
