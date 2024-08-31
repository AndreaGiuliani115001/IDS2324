package it.unicam.cs.terravalore.controller;

import it.unicam.cs.terravalore.model.Comune;
import it.unicam.cs.terravalore.model.PuntoInteresse;
import it.unicam.cs.terravalore.model.utenti.Contributore;
import it.unicam.cs.terravalore.model.utenti.TuristaAutenticato;
import it.unicam.cs.terravalore.model.utenti.Utente;
import it.unicam.cs.terravalore.repository.UtenteRepository;
import it.unicam.cs.terravalore.service.PuntoInteresseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Il controller per gestire le richieste relative ai punti di interesse.
 */
@Controller
public class PuntoInteresseController {

    @Autowired
    private PuntoInteresseService puntoInteresseService;
    @Autowired
    private UtenteRepository utenteRepository;

    /**
     * Mostra la lista dei punti di interesse nella homepage.
     *
     * @param model Il modello per passare i dati alla vista.
     * @return Il nome del template HTML da visualizzare.
     */

    @GetMapping("/")
    public String mostraPuntiDiInteresseGuest(Model model) {

        List<PuntoInteresse> puntiDiInteresse;
        puntiDiInteresse = puntoInteresseService.trovaTuttiPuntiDiInteresse();
        model.addAttribute("puntiDiInteresse", puntiDiInteresse);
        return "index";
    }

    @GetMapping("/dashboard")
    public String mostraPuntiDiInteresse(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        List<PuntoInteresse> puntiDiInteresse;

        if (auth != null && auth.isAuthenticated() && !(auth instanceof AnonymousAuthenticationToken)) {
            String username = auth.getName();
            Utente utente = utenteRepository.findByUsername(username).orElse(null);

            if (utente instanceof Contributore) {
                List<Comune> comuni = ((Contributore) utente).getComuniAssociati();
                puntiDiInteresse = comuni.stream()
                        .flatMap(comune -> comune.getPuntiDiInteresse().stream())
                        .collect(Collectors.toList());
            } else if (utente instanceof TuristaAutenticato) {
                puntiDiInteresse = puntoInteresseService.trovaTuttiPuntiDiInteresse();  // Or specific criteria
            } else {
                puntiDiInteresse = puntoInteresseService.trovaTuttiPuntiDiInteresse();
            }
        } else {
            // User is guest
            puntiDiInteresse = puntoInteresseService.trovaTuttiPuntiDiInteresse();
        }

        model.addAttribute("puntiDiInteresse", puntiDiInteresse);
        return "dashboard";
    }
}

