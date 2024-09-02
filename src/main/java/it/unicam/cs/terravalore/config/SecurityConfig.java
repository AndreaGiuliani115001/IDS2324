package it.unicam.cs.terravalore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // Disabilitare CSRF se non necessario
                .authorizeHttpRequests(auth -> auth  // Autorizzazione delle richieste
                        .requestMatchers("/", "/login", "/puntiInteresse/comune/**", "/contenuti/puntoInteresse/**").permitAll()  // Endpoint pubblici
                        .anyRequest().authenticated())  // Tutto il resto richiede autenticazione
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/dashboard", true)
                        .permitAll())  // Configurazione del login
                .logout(logout -> logout
                        .logoutSuccessUrl("/").permitAll());  // Configurazione del logout

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
