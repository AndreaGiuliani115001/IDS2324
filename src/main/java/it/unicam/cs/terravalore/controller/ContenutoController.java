package it.unicam.cs.terravalore.controller;

import it.unicam.cs.terravalore.model.Contenuto;
import it.unicam.cs.terravalore.service.ContenutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ContenutoController {

    @Autowired
    private ContenutoService contenutoService;

    @GetMapping("/contenuti")
    public String getContenuti(Model model) {
        List<Contenuto> contenuti = contenutoService.findAll();
        model.addAttribute("contenuti", contenuti);
        return "contenuti";
    }
}
