package org.cortesrmzcau.security;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@Log4j2
public class SecurityConfiguration {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) {
        try {
            httpSecurity.authorizeHttpRequests(auth ->
                    // anyRequest.permiteAll() es para permitir que se acceda a cualquier endpoint
                    auth.requestMatchers("/v1/mensaje").authenticated()
                            .anyRequest().permitAll())
                            .formLogin(Customizer.withDefaults())
                            .httpBasic(Customizer.withDefaults());

            return httpSecurity.build();
        } catch (Exception exception) {
            throw new IllegalStateException(exception);
        }
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
