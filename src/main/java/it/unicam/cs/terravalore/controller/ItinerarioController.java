package it.unicam.cs.terravalore.controller;

import it.unicam.cs.terravalore.model.Itinerario;
import it.unicam.cs.terravalore.service.ItinerarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ItinerarioController {

    @Autowired
    private ItinerarioService itinerarioService;

    @GetMapping("/itinerari")
    public String getItinerari(Model model) {
        List<Itinerario> itinerari = itinerarioService.findAll();
        model.addAttribute("itinerari", itinerari);
        return "itinerari";
    }
}
