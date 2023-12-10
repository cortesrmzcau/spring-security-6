package org.cortesrmzcau.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) {
        try {
            httpSecurity.authorizeHttpRequests(auth ->
                    // anyRequest.permiteAll() es para permitir que se acceda a cualquier endpoint
                    auth.requestMatchers("/loans", "/about_us", "/welcome").authenticated()
                            .anyRequest().permitAll())
                            .formLogin(Customizer.withDefaults())
                            .httpBasic(Customizer.withDefaults());

            return httpSecurity.build();
        } catch (Exception exception) {
            throw new IllegalStateException(exception);
        }
    }
}
