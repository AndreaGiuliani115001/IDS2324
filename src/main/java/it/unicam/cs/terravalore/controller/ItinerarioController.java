package it.unicam.cs.terravalore.controller;

import it.unicam.cs.terravalore.model.Itinerario;
import it.unicam.cs.terravalore.service.ItinerarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Controller per gestire le richieste relative agli itinerari.
 * Questa classe è responsabile di recuperare i dati degli itinerari
 * dal servizio e di passarli al template di visualizzazione.
 */
@Controller
public class ItinerarioController {

    @Autowired
    private ItinerarioService itinerarioService;

    /**
     * Gestisce la richiesta GET per ottenere e visualizzare tutti gli itinerari.
     * Recupera la lista degli itinerari tramite il servizio {@link ItinerarioService}
     * e la aggiunge al modello per essere visualizzata nella pagina "itinerari".
     *
     * @param model Il modello utilizzato per passare dati alla vista.
     * @return Il nome del template da visualizzare ("itinerari").
     */
    @GetMapping("/itinerari")
    public String getItinerari(Model model) {
        List<Itinerario> itinerari = itinerarioService.findAll();
        model.addAttribute("itinerari", itinerari);
        return "itinerari";
    }
}
