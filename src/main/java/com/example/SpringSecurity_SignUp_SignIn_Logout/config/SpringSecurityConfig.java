package com.example.SpringSecurity_SignUp_SignIn_Logout.config;


import jakarta.servlet.DispatcherType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        // csrf(), cors() deprecated Method.
        http.csrf().disable().cors().disable()
                .authorizeHttpRequests(request -> request
                        .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
                        .anyRequest().authenticated()   // 어떤 요청이라도 인증 필요.
                )
                .formLogin(login->login
                        .defaultSuccessUrl("/views/dashboard", true)
                        .permitAll()
                )
                .logout(withDefaults());

        return http.build();

    }


}
