package it.unicam.cs.terravalore.controller;

import it.unicam.cs.terravalore.model.PuntoInteresse;
import it.unicam.cs.terravalore.service.PuntoInteresseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Il controller per gestire le richieste relative ai punti di interesse.
 */
@Controller
public class PuntoInteresseController {

    @Autowired
    private PuntoInteresseService puntoInteresseService;

    /**
     * Mostra la lista dei punti di interesse nella homepage.
     *
     * @param model Il modello per passare i dati alla vista.
     * @return Il nome del template HTML da visualizzare.
     */
    @GetMapping("/")
    public String mostraPuntiDiInteresse(Model model) {
        List<PuntoInteresse> puntiDiInteresse = puntoInteresseService.trovaTuttiPuntiDiInteresse();
        model.addAttribute("puntiDiInteresse", puntiDiInteresse);
        return "index";
    }
}

