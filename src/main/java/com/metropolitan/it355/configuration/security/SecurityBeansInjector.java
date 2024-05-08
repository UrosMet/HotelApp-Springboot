package com.metropolitan.it355.configuration.security;

import com.metropolitan.it355.authentication.UserProvider;
import com.metropolitan.it355.repository.RecepcionerRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SecurityBeansInjector {

    private RecepcionerRepository userRepository;
    private UserProvider userProvider;


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {

        return authenticationConfiguration.getAuthenticationManager();
    }


    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userProvider.userDetailsService());
        provider.setPasswordEncoder(userProvider.passwordEncoder());

        return provider;
    }

}
