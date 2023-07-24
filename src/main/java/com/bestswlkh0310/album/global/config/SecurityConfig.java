package com.bestswlkh0310.album.global.config;

import com.bestswlkh0310.album.domain.user.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final UserDetailsServiceImpl userDetailsService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/sign/**").permitAll()
                .antMatchers("/**").hasRole("USER")
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/sign/in").defaultSuccessUrl("/home", true)
                .loginProcessingUrl("/sign/in").defaultSuccessUrl("/home", true)
                .failureUrl("/sign/in")
                .and()
                .userDetailsService(userDetailsService);
        return http.build();
    }
}