package it.unicam.cs.terravalore.controller;

import it.unicam.cs.terravalore.model.Comune;
import it.unicam.cs.terravalore.service.ComuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ComuneController {

    @Autowired
    private ComuneService comuneService;

    @GetMapping("/")
    public String getComuni(Model model) {
        List<Comune> comuni = comuneService.findAll();
        model.addAttribute("comuni", comuni);
        return "index.html";
    }
}
