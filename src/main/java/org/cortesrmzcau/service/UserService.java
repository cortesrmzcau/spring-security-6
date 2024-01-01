package org.cortesrmzcau.service;

import lombok.AllArgsConstructor;
import org.cortesrmzcau.repositories.ILoginRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final ILoginRepository iLoginRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return this.iLoginRepository.findByEmail(email).map(usersEntity -> {
            var authorities = List.of(new SimpleGrantedAuthority("ROLE_USER"));
            return new User(usersEntity.getEmail(), usersEntity.getPassword(), authorities);
        }).orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado por email"));
    }
}
