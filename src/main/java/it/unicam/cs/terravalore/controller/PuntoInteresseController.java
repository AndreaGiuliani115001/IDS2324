package it.unicam.cs.terravalore.controller;

import it.unicam.cs.terravalore.model.PuntoInteresse;
import it.unicam.cs.terravalore.repository.UtenteRepository;
import it.unicam.cs.terravalore.service.PuntoInteresseService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String mostraPuntiDiInteressePerComune(@PathVariable("comuneId") Long comuneId, Model model) {
        List<PuntoInteresse> puntiDiInteresse = puntoInteresseService.findByComuneId(comuneId);
        model.addAttribute("puntiDiInteresse", puntiDiInteresse);
        return "puntiDiInteresse";  // Nome della view Thymeleaf
    }

}

