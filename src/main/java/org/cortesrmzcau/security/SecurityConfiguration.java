package org.cortesrmzcau.security;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.jaas.memory.InMemoryConfiguration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@Log4j2
public class SecurityConfiguration {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) {
        try {
            httpSecurity.authorizeHttpRequests(auth ->
                    // anyRequest.permiteAll() es para permitir que se acceda a cualquier endpoint
                    auth.requestMatchers("/loans", "/about_us", "/welcome", "/cards").authenticated()
                            .anyRequest().permitAll())
                            .formLogin(Customizer.withDefaults())
                            .httpBasic(Customizer.withDefaults());

            return httpSecurity.build();
        } catch (Exception exception) {
            throw new IllegalStateException(exception);
        }
    }

    /*@Bean
    InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        UserDetails admin = User.withUsername("admin")
                .password("123")
                .authorities("ADMIN")
                .build();

        UserDetails user = User.withUsername("user")
                .password("123")
                .authorities("USER")
                .build();

        return new InMemoryUserDetailsManager(admin, user);
    }*/

    // Si se usa CustomerUserDetails esta parte se comenta
    /*@Bean
    UserDetailsService userDetailsService (DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }*/

    @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}
