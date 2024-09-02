package it.unicam.cs.terravalore.controller;


import it.unicam.cs.terravalore.config.CustomUserDetails;
import it.unicam.cs.terravalore.model.PuntoInteresse;
import it.unicam.cs.terravalore.model.utenti.*;
import it.unicam.cs.terravalore.repository.UtenteRepository;
import it.unicam.cs.terravalore.service.PuntoInteresseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Il controller per gestire le richieste relative ai punti di interesse.
 */
@Controller
public class PuntoInteresseController {

    @Autowired
    private PuntoInteresseService puntoInteresseService;
    @Autowired
    private UtenteRepository utenteRepository;


    @GetMapping("/puntiInteresse/comune/{comuneId}")
    public String mostraPuntiDiInteressePerComune(@PathVariable("comuneId") Long comuneId, @AuthenticationPrincipal UserDetails userDetails, Model model) {
        List<PuntoInteresse> puntiDiInteresse = puntoInteresseService.findByComuneId(comuneId);
        model.addAttribute("puntiDiInteresse", puntiDiInteresse);

        if (userDetails != null) {
            Utente utente = ((CustomUserDetails) userDetails).getUtente();

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
        } else {
            // Se l'utente non è autenticato
            model.addAttribute("isGuest", true);
        }

        return "puntiDiInteresse";  // Nome della view Thymeleaf
    }

}

