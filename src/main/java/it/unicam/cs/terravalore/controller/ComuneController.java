package it.unicam.cs.terravalore.controller;

import it.unicam.cs.terravalore.model.Comune;
import it.unicam.cs.terravalore.service.ComuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Controller per gestire le richieste relative ai comuni.
 * Questa classe è responsabile di recuperare i dati dei comuni
 * dal servizio e di passarli al template di visualizzazione.
 */
@Controller
public class ComuneController {

    @Autowired
    private ComuneService comuneService;

    /**
     * Gestisce la richiesta GET per la root ("/") dell'applicazione.
     * Recupera la lista dei comuni tramite il servizio {@link ComuneService}
     * e la aggiunge al modello per essere visualizzata nella pagina index.html.
     *
     * @param model Il modello utilizzato per passare dati alla vista.
     * @return Il nome del template da visualizzare ("index.html").
     */
    @GetMapping("/")
    public String getComuni(Model model) {
        List<Comune> comuni = comuneService.findAll();
        model.addAttribute("comuni", comuni);
        return "index.html";
    }
}
