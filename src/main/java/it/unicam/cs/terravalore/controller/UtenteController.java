package it.unicam.cs.terravalore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import it.unicam.cs.terravalore.config.CustomUserDetails;
import it.unicam.cs.terravalore.model.Comune;
import it.unicam.cs.terravalore.model.utenti.*;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import it.unicam.cs.terravalore.service.ComuneService;

import java.util.List;

/**
 * Controller per gestire le richieste relative agli utenti.
 * Questa classe gestisce la visualizzazione della pagina di login e della dashboard dell'utente.
 */
@Controller
public class UtenteController {

    @Autowired
    private ComuneService comuneService;

    /**
     * Gestisce la richiesta GET per visualizzare la pagina di login.
     *
     * @return Il nome del template Thymeleaf da visualizzare ("login").
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * Gestisce la richiesta GET per visualizzare la dashboard dell'utente autenticato.
     * Recupera i comuni associati all'utente tramite il servizio {@link ComuneService} e
     * configura il modello con informazioni specifiche basate sul tipo di utente.
     *
     * @param userDetails I dettagli dell'utente autenticato.
     * @param model       Il modello utilizzato per passare dati alla vista.
     * @return Il nome del template Thymeleaf da visualizzare ("dashboard").
     */
    @GetMapping("/dashboard")
    public String dashboard(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        Utente utente = ((CustomUserDetails) userDetails).getUtente();

        List<Comune> comuniAssociati = comuneService.findAllByUser(utente);
        model.addAttribute("comuni", comuniAssociati);

        if (utente instanceof Contributore) {
            model.addAttribute("isContributore", true);
        } else if (utente instanceof ContributoreAutorizzato) {
            model.addAttribute("isContributoreAutorizzato", true);
        } else if (utente instanceof Curatore) {
            model.addAttribute("isCuratore", true);
        } else if (utente instanceof Gestore) {
            model.addAttribute("isGestore", true);
        } else if (utente instanceof TuristaAutenticato) {
            model.addAttribute("isTuristaAutenticato", true);
        }

        return "dashboard";
    }
}
