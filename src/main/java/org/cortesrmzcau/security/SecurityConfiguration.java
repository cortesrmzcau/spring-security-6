package org.cortesrmzcau.security;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.jaas.memory.InMemoryConfiguration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
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
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.security.web.csrf.CsrfTokenRequestHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import javax.sql.DataSource;
import java.util.List;

@Configuration
@EnableMethodSecurity
@Log4j2
public class SecurityConfiguration {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity, JwtValidationFilter jwtValidationFilter) throws Exception {
        httpSecurity.sessionManagement(httpSecuritySessionManagementConfigurer -> httpSecuritySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        var requestHandler = new CsrfTokenRequestAttributeHandler();
        requestHandler.setCsrfRequestAttributeName("_csrf");

        try {
            httpSecurity.authorizeHttpRequests(auth ->
                    // anyRequest.permiteAll() es para permitir que se acceda a cualquier endpoint
                    //auth.requestMatchers("/loans", "/about_us", "/cards").authenticated()
                    auth
                            .requestMatchers("/loans").hasRole("VIEW_LOANS") // hasAuthority("VIEW_LOANS")
                            .requestMatchers("/balance").hasAuthority("VIEW_BALANCE")
                            .requestMatchers("/cards").hasAuthority("VIEW_CARDS") // hasRole("ADMIN")
                            //.requestMatchers("/accounts").hasAnyAuthority("VIEW_ACCOUNT", "VIEW_CARDS")
                            .anyRequest().permitAll())
                            .formLogin(Customizer.withDefaults())
                            .httpBasic(Customizer.withDefaults());
            httpSecurity.addFilterAfter(jwtValidationFilter, BasicAuthenticationFilter.class);
            httpSecurity.cors(cors -> corsConfigurationSource());
            httpSecurity.csrf(csrf -> csrf
                    .csrfTokenRequestHandler(requestHandler)
                    .ignoringRequestMatchers("/welcome", "/about_us", "/authenticate")
                    .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
                    .addFilterAfter(new CsrfCookieFilter(), BasicAuthenticationFilter.class);
            return httpSecurity.build();
        } catch (Exception exception) {
            throw new IllegalStateException(exception);
        }
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        var config = new CorsConfiguration();

        //config.setAllowedOrigins(List.of("http://localhost:4200"));
        config.setAllowedOrigins(List.of("*"));
        config.setAllowedMethods(List.of("GET", "POST"));
        config.setAllowedHeaders(List.of("*"));

        var source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return source;
    }

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

}
