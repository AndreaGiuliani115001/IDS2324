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

/**
 * Controller per gestire le richieste relative ai contenuti di un punto di interesse.
 * Questa classe è responsabile di recuperare i contenuti associati a un punto di interesse
 * e di gestire la visualizzazione basata sul tipo di utente autenticato.
 */
@Controller
public class ContenutoController {

    @Autowired
    private ContenutoService contenutoService;

    /**
     * Gestisce la richiesta GET per visualizzare i contenuti associati a un punto di interesse specifico.
     * Il metodo recupera i contenuti tramite il servizio {@link ContenutoService} e li passa al modello
     * per essere visualizzati. Inoltre, imposta attributi nel modello per identificare il tipo di utente autenticato.
     *
     * @param puntoId L'ID del punto di interesse di cui visualizzare i contenuti.
     * @param userDetails I dettagli dell'utente autenticato.
     * @param model Il modello utilizzato per passare dati alla vista.
     * @return Il nome del template Thymeleaf da visualizzare ("contenuti").
     */
    @GetMapping("/contenuti/puntoInteresse/{puntoId}")
    public String mostraContenutiPerPuntoInteresse(@PathVariable("puntoId") Long puntoId,
                                                   @AuthenticationPrincipal UserDetails userDetails,
                                                   Model model) {
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
