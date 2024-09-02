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

@Controller
public class UtenteController {

    @Autowired
    private ComuneService comuneService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/dashboard")
    public String dashboard(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        Utente utente = ((CustomUserDetails) userDetails).getUtente();

        List<Comune> comuniAssociati = comuneService.findAllByUser(utente);
        model.addAttribute("comuni", comuniAssociati);

        // Configurare la dashboard in base al tipo di utente
        if (utente instanceof Contributore) {
            model.addAttribute("isContributore", true);
            // Altre configurazioni specifiche per contributore
        } else if (utente instanceof ContributoreAutorizzato) {
            model.addAttribute("isContributoreAutorizzato", true);
            // Configurazioni per contributore autorizzato
        } else if (utente instanceof Curatore) {
            model.addAttribute("isCuratore", true);
            // Configurazioni per curatore
        } else if (utente instanceof Gestore) {
            model.addAttribute("isGestore", true);
            // Configurazioni per gestore
        } else if (utente instanceof TuristaAutenticato) {
            model.addAttribute("isTuristaAutenticato", true);
            // Configurazioni per turista autenticato
        }

        return "dashboard";
    }

}
