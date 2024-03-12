package com.example.springbootsecuritydemo.config;

import com.example.springbootsecuritydemo.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
@Bean  // authentication config
    public UserDetailsService userDetailsService() {
//         UserDetails admin = User.withUsername("maharana")
//                .password(passwordEncoder.encode("premraj@1112"))
//                .roles("ADMIN")
//                .build();
//
//         UserDetails user = User.withUsername("kittu")
//                 .password(passwordEncoder.encode("kittu123"))
//                 .roles("USER")
//                 .build();
//         return new InMemoryUserDetailsManager(admin,user);
    return  new UserService();
    }
@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
@Bean  // authrization config
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/msg","/add").permitAll()
                            .anyRequest().authenticated();
                   // auth.requestMatchers("/user").hasRole("USER");
                  //  auth.requestMatchers("/admin").hasRole("ADMIN");
        })
                .formLogin(Customizer.withDefaults())
                .build();
    }
@Bean  // this will communicate with db after login
    public AuthenticationProvider AuthenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }
}
