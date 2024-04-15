package org.cortesrmzcau.security;

import lombok.AllArgsConstructor;
import org.cortesrmzcau.repositories.CustomerRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {
    private final CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.customerRepository.findByEmail(username)
                .map(customerEntity -> {
                    final var authorities = customerEntity.getRoles()
                            .stream()
                            .map(roleEntity -> new SimpleGrantedAuthority(roleEntity.getName()))
                            .toList();
                    return new User(customerEntity.getEmail(), customerEntity.getPassword(), authorities);
                }).orElseThrow(() -> new UsernameNotFoundException("User not exist"));
    }
}
