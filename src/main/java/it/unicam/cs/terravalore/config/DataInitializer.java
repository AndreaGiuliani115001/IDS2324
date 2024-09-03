package it.unicam.cs.terravalore.config;

import it.unicam.cs.terravalore.model.utenti.*;
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
            Comune comune1 = new Comune("Comune di Roma", "La capitale d'Italia, famosa per la sua storia e monumenti antichi.", null, null);
            Comune comune2 = new Comune("Comune di Firenze", "Culla del Rinascimento, famosa per la sua arte e architettura.", null, null);
            Comune comune3 = new Comune("Comune di Venezia", "Città lagunare famosa per i suoi canali e il Carnevale.", null, null);
            comuneRepository.saveAll(Arrays.asList(comune1, comune2, comune3));

            // Creazione di punti di interesse
            PuntoInteresse punto1 = new PuntoInteresse("Colosseo", "Anfiteatro romano simbolo della città di Roma.", "Fisico", comune1, null);
            PuntoInteresse punto11 = new PuntoInteresse("Fontana di Trevi", "Fontana barocca situata nel centro di Roma, famosa per il lancio della monetina.", "Fisico", comune1, null);
            PuntoInteresse punto2 = new PuntoInteresse("Ponte Vecchio", "Ponte medievale che attraversa l'Arno a Firenze, noto per le sue botteghe di gioiellieri.", "Fisico", comune2, null);
            PuntoInteresse punto3 = new PuntoInteresse("Piazza San Marco", "La piazza principale di Venezia, nota per la Basilica di San Marco e il Campanile.", "Fisico", comune3, null);
            puntoInteresseRepository.saveAll(Arrays.asList(punto1, punto11, punto2, punto3));

            // Creazione di contenuti associati ai punti di interesse
            Contenuto contenuto1 = new Contenuto("Guida Fotografica", createDate(2024, 8, 30), true, punto1);
            Contenuto contenuto11 = new Contenuto("Storia del Colosseo", createDate(2024, 8, 30), true, punto1);
            Contenuto contenuto2 = new Contenuto("Architettura della Fontana di Trevi", createDate(2024, 8, 30), false, punto11);
            Contenuto contenuto3 = new Contenuto("La Storia di Ponte Vecchio", createDate(2024, 8, 30), false, punto2);
            contenutoRepository.saveAll(Arrays.asList(contenuto1, contenuto11, contenuto2, contenuto3));

            // Creazione del contributore e associazione con i comuni
            Contributore contributore = new Contributore();
            contributore.setUsername("contributore");
            contributore.setPassword(passwordEncoder.encode("password"));
            contributore.setActive(true);
            contributore.setComuniAssociati(new HashSet<>(Arrays.asList(comune1, comune2)));
            utenteRepository.save(contributore);

            // Creazione del contributore autorizzato
            ContributoreAutorizzato contributoreAutorizzato = new ContributoreAutorizzato();
            contributoreAutorizzato.setUsername("contributoreAutorizzato");
            contributoreAutorizzato.setPassword(passwordEncoder.encode("password"));
            contributoreAutorizzato.setActive(true);
            contributoreAutorizzato.setComuniAssociati(new HashSet<>(Arrays.asList(comune2)));
            utenteRepository.save(contributoreAutorizzato);

            // Creazione del curatore
            Curatore curatore = new Curatore();
            curatore.setUsername("curatore");
            curatore.setPassword(passwordEncoder.encode("password"));
            curatore.setActive(true);
            curatore.setComuniAssociati(new HashSet<>(Arrays.asList(comune1, comune3)));
            utenteRepository.save(curatore);

            // Creazione del gestore
            Gestore gestore = new Gestore();
            gestore.setUsername("gestore");
            gestore.setPassword(passwordEncoder.encode("password"));
            gestore.setActive(true);
            gestore.setComuniAssociati(new HashSet<>(Arrays.asList(comune1)));
            utenteRepository.save(gestore);

            // Creazione del turista autenticato
            TuristaAutenticato turistaAutenticato = new TuristaAutenticato();
            turistaAutenticato.setUsername("turistaAuth");
            turistaAutenticato.setPassword(passwordEncoder.encode("password"));
            turistaAutenticato.setActive(true);
            utenteRepository.save(turistaAutenticato);

            // Creazione dell'animatore
            Animatore animatore = new Animatore();
            animatore.setUsername("animatore");
            animatore.setPassword(passwordEncoder.encode("password"));
            animatore.setActive(true);
            utenteRepository.save(animatore);
        };
    }

    // Metodo di utilità per creare oggetti Date
    private Date createDate(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day); // I mesi in Calendar vanno da 0 (Gennaio) a 11 (Dicembre)
        return calendar.getTime();
    }
}
