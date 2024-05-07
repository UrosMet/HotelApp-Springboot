package com.metropolitan.it355.configuration.security;

import com.metropolitan.it355.filters.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import java.util.List;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {


    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(
                        cors -> cors.configurationSource(request -> {
                            CorsConfiguration corsConfiguration = new CorsConfiguration();
                            corsConfiguration.setAllowedOrigins(List.of("http://localhost:4200"));
                            corsConfiguration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE"));
                            corsConfiguration.setAllowedHeaders(List.of("Authorization", "Cache-Control", "Content-Type"));
                            corsConfiguration.setAllowCredentials(true);
                            return corsConfiguration;
                        })
                )
                .sessionManagement(sessionMangConfig -> sessionMangConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests( authConfig -> {
                    authConfig
                            .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                            .requestMatchers(HttpMethod.POST, "/auth/register").permitAll()
                            .requestMatchers("/error").permitAll()
                            //Soba
                            .requestMatchers(HttpMethod.POST , "/soba/**").hasAuthority("FULL_ACCESS")
                            .requestMatchers(HttpMethod.PUT , "/soba/**").hasAuthority("FULL_ACCESS")
                            .requestMatchers(HttpMethod.DELETE , "/soba/**").hasAuthority("FULL_ACCESS")
                            .requestMatchers(HttpMethod.GET , "/soba/**").hasAnyAuthority("READ_ONLY","FULL_ACCESS")
                            //Gost
                            .requestMatchers("/gost/**").hasAnyAuthority("READ_ONLY","FULL_ACCESS")
                            //Rezervacija
                            .requestMatchers(HttpMethod.GET , "/rezervacija/**").hasAnyAuthority("READ_ONLY","FULL_ACCESS")
                            .requestMatchers(HttpMethod.POST , "/rezervacija/**").hasAnyAuthority("READ_ONLY","FULL_ACCESS")
                            .requestMatchers(HttpMethod.PUT , "/rezervacija/**").hasAnyAuthority("READ_ONLY","FULL_ACCESS")
                            .requestMatchers(HttpMethod.DELETE , "/rezervacija/**").hasAnyAuthority("READ_ONLY","FULL_ACCESS")
                            //Transport
                            .requestMatchers(HttpMethod.GET , "/transport/**").hasAnyAuthority("READ_ONLY","FULL_ACCESS")
                            .requestMatchers(HttpMethod.POST , "/transport/**").hasAnyAuthority("READ_ONLY","FULL_ACCESS")
                            .requestMatchers(HttpMethod.PUT , "/transport/**").hasAnyAuthority("READ_ONLY","FULL_ACCESS")
                            .requestMatchers(HttpMethod.DELETE , "/transport/**").hasAnyAuthority("READ_ONLY","FULL_ACCESS")
                            //Cenovnik
                            .requestMatchers(HttpMethod.GET , "/cenovnik/**").hasAnyAuthority("READ_ONLY","FULL_ACCESS")
                            .requestMatchers(HttpMethod.POST , "/cenovnik/**").hasAuthority("FULL_ACCESS")
                            .requestMatchers(HttpMethod.PUT , "/cenovnik/**").hasAuthority("FULL_ACCESS")
                            .requestMatchers(HttpMethod.DELETE , "/cenovnik/**").hasAuthority("FULL_ACCESS")
                            //SobaSlike
                            .requestMatchers(HttpMethod.GET , "/sobaslike/**").hasAnyAuthority("READ_ONLY","FULL_ACCESS")
                            .requestMatchers(HttpMethod.POST , "/sobaslike/**").hasAuthority("FULL_ACCESS")
                            .requestMatchers(HttpMethod.PUT , "/sobaslike/**").hasAuthority("FULL_ACCESS")
                            .requestMatchers(HttpMethod.DELETE , "/sobaslike/**").hasAuthority("FULL_ACCESS")
                            //Recepcioner
                            .requestMatchers(HttpMethod.PUT , "/recepcioner/**").hasAnyAuthority("READ_ONLY","FULL_ACCESS")
                            .requestMatchers(HttpMethod.GET , "/recepcioner/**").hasAuthority("FULL_ACCESS")
                            .requestMatchers(HttpMethod.POST , "/recepcioner/**").hasAuthority("FULL_ACCESS")
                            .requestMatchers(HttpMethod.DELETE , "/recepcioner/**").hasAuthority("FULL_ACCESS")
                            //Logout
                            .requestMatchers(HttpMethod.POST , "/auth/logout").hasAnyAuthority("READ_ONLY","FULL_ACCESS")
                            //Admin
                            .requestMatchers("/admin/**").hasAuthority("FULL_ACCESS")
                            .requestMatchers("/actuator/**").hasAuthority("FULL_ACCESS")
                            .anyRequest().denyAll();
                });

        return http.build();

    }
















//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http
//                .csrf(AbstractHttpConfigurer::disable)
//                .cors(
//                        cors -> cors.configurationSource(request -> {
//                            CorsConfiguration corsConfiguration = new CorsConfiguration();
//                            corsConfiguration.setAllowedOrigins(List.of("*"));
//                            corsConfiguration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE"));
//                            corsConfiguration.setAllowedHeaders(List.of("Authorization", "Cache-Control", "Content-Type"));
//                            corsConfiguration.setAllowCredentials(true);
//                            return corsConfiguration;
//                        })
//                )
//                .rememberMe(rememberMe ->{
//                    rememberMe.tokenValiditySeconds(86400);
//                    rememberMe.key("key");
//                    rememberMe.userDetailsService((UserDetailsService) recepcionerService);
//                })
//                .sessionManagement(session ->{
//                    session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//                    session.maximumSessions(1);
//                })
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/gost/**", "/soba/**", "/cenovnik/**", "/recepcioner/**", "/rezervacija/**", "/transport/**", "/admin/**", "/actuator/**").hasRole("ADMIN")
//                        .requestMatchers("/login", "/logout").permitAll()
//                        .anyRequest().authenticated()
//                )
////                .formLogin(form -> {
////                    form.loginPage("/login");
////                    form.permitAll();
////                })
////                .logout(logout ->{
////                    logout.logoutUrl("/logout");
////                    logout.logoutSuccessUrl("/");
////                    logout.permitAll();
////                })
//                .httpBasic(httpBasic -> {})
//                .build();
//    }
//
//
//
//
//    @Bean
//    @Primary
//    public UserDetailsService userDetailsService() {
//        return (UserDetailsService) recepcionerService;
//    }
//
//    @Bean
//    public AuthenticationProvider authenticationProvider(){
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//        authProvider.setUserDetailsService((UserDetailsService) recepcionerService);
//        authProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
//        return authProvider;
//    }
//
//    @Bean
//    public AuthenticationManager authManager(HttpSecurity http,
//                                             ApplicationContext applicationContext) throws Exception {
//        AuthenticationManagerBuilder authenticationManagerBuilder =
//                http.getSharedObject(AuthenticationManagerBuilder.class);
//        UserDetailsService userDetailsService =
//                applicationContext.getBean(UserDetailsService.class);
//        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//        return authenticationManagerBuilder.build();
//    }
//
//
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
//    }

}
