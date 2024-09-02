package it.unicam.cs.terravalore.controller;

import it.unicam.cs.terravalore.config.CustomUserDetails;
import it.unicam.cs.terravalore.model.Contenuto;
import it.unicam.cs.terravalore.model.utenti.*;
import it.unicam.cs.terravalore.service.ContenutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ContenutoController {

    @Autowired
    private ContenutoService contenutoService;

    @GetMapping("/contenuti/puntoInteresse/{puntoId}")
    public String mostraContenutiPerPuntoInteresse(@PathVariable("puntoId") Long puntoId, @AuthenticationPrincipal UserDetails userDetails, Model model) {
        List<Contenuto> contenuti = contenutoService.findByPuntoInteresseId(puntoId);
        model.addAttribute("contenuti", contenuti);

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

        return "contenuti";  // Vista Thymeleaf per i contenuti di un punto di interesse
    }
}
