package it.unicam.cs.terravalore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Configurazione della sicurezza per l'applicazione.
 *
 * Questa classe configura la sicurezza web per l'applicazione utilizzando Spring Security.
 * Definisce le regole di autorizzazione delle richieste, la configurazione del login e del logout,
 * e fornisce un encoder per le password.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /**
     * Configura le regole di sicurezza per le richieste HTTP.
     *
     * Questo metodo definisce come le richieste HTTP devono essere autorizzate e gestite.
     * Disabilita la protezione CSRF, configura le autorizzazioni per endpoint specifici,
     * e imposta le pagine di login e logout.
     *
     * @param http L'oggetto {@link HttpSecurity} per configurare la sicurezza delle richieste.
     * @return Un {@link SecurityFilterChain} configurato con le regole di sicurezza.
     * @throws Exception Se si verifica un errore durante la configurazione della sicurezza.
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // Disabilita la protezione CSRF se non necessaria
                .authorizeHttpRequests(auth -> auth  // Configura l'autorizzazione delle richieste
                        .requestMatchers("/", "/login", "/puntiInteresse/comune/**", "/contenuti/puntoInteresse/**").permitAll()  // Endpoint pubblici accessibili a tutti
                        .anyRequest().authenticated())  // Tutte le altre richieste richiedono autenticazione
                .formLogin(form -> form
                        .loginPage("/login")  // Configura la pagina di login
                        .defaultSuccessUrl("/dashboard", true)  // URL di reindirizzamento dopo il login
                        .permitAll())  // Permette l'accesso alla pagina di login a tutti
                .logout(logout -> logout
                        .logoutSuccessUrl("/").permitAll());  // Configura la pagina di reindirizzamento dopo il logout

        return http.build();  // Restituisce la configurazione di sicurezza costruita
    }

    /**
     * Fornisce un encoder per le password.
     *
     * Questo metodo crea e restituisce un'istanza di {@link BCryptPasswordEncoder},
     * utilizzata per codificare le password degli utenti in modo sicuro.
     *
     * @return Un {@link PasswordEncoder} per codificare le password.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  // Restituisce un encoder BCrypt per le password
    }
}
