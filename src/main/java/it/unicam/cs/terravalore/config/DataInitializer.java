package it.unicam.cs.terravalore.config;

import it.unicam.cs.terravalore.model.utenti.Contributore;
import it.unicam.cs.terravalore.model.utenti.TuristaAutenticato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import it.unicam.cs.terravalore.model.*;
import it.unicam.cs.terravalore.repository.*;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;

@Configuration
public class DataInitializer {

    @Autowired
    private UtenteRepository utenteRepository;
    @Autowired
    private ComuneRepository comuneRepository;
    @Autowired
    private PuntoInteresseRepository puntoInteresseRepository;
    @Autowired
    private ContenutoRepository contenutoRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    CommandLineRunner initDatabase() {
        return args -> {

            // Creazione di comuni
            Comune comune1 = new Comune("Comune1", "Descrizione di Comune1", null, null);
            Comune comune2 = new Comune("Comune2", "Descrizione di Comune2", null, null);
            Comune comune3 = new Comune("Comune3", "Descrizione di Comune3", null, null);
            comuneRepository.saveAll(Arrays.asList(comune1, comune2, comune3));

            // Creazione di punti di interesse
            PuntoInteresse punto1 = new PuntoInteresse("Punto1", "Descrizione Punto1", "Fisico", comune1, null);
            PuntoInteresse punto11 = new PuntoInteresse("Punto11", "Descrizione Punto11", "Fisico", comune1, null);
            PuntoInteresse punto2 = new PuntoInteresse("Punto2", "Descrizione Punto2", "Logico", comune2, null);
            PuntoInteresse punto3 = new PuntoInteresse("Punto3", "Descrizione Punto3", "Fisico", comune3, null);
            puntoInteresseRepository.saveAll(Arrays.asList(punto1, punto11, punto2, punto3));

            // Creazione di contenuti associati ai punti di interesse
            Contenuto contenuto1 = new Contenuto("Immagine", createDate(2024, 8, 30), true, punto1);
            Contenuto contenuto11 = new Contenuto("Testo", createDate(2024, 8, 30), true, punto1);
            Contenuto contenuto2 = new Contenuto("Documento", createDate(2024, 8, 30), false, punto2);
            Contenuto contenuto3 = new Contenuto("Testo", createDate(2024, 8, 30), false, punto3);
            contenutoRepository.saveAll(Arrays.asList(contenuto1, contenuto11, contenuto2, contenuto3));

            // Creazione del contributore e associazione con i comuni
            Contributore contributore = new Contributore();
            contributore.setUsername("contributore");
            contributore.setPassword(passwordEncoder.encode("password"));
            contributore.setActive(true);

            // Associazione dei comuni al contributore
            contributore.setComuniAssociati(new HashSet<>(Arrays.asList(comune1, comune2)));

            utenteRepository.save(contributore);

            // Creazione del turista autenticato
            TuristaAutenticato turistaAutenticato = new TuristaAutenticato();
            turistaAutenticato.setUsername("turistaAuth");
            turistaAutenticato.setPassword(passwordEncoder.encode("password"));
            turistaAutenticato.setActive(true);
            utenteRepository.save(turistaAutenticato);
        };
    }

    // Metodo di utilità per creare oggetti Date
    private Date createDate(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day); // I mesi in Calendar vanno da 0 (Gennaio) a 11 (Dicembre)
        return calendar.getTime();
    }
}
