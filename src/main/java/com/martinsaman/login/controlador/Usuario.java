package com.martinsaman.login.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/")
public class Usuario {


    @GetMapping
    public String home (Model model, Principal principal){
        model.addAttribute("titulo","Home");
        model.addAttribute("usuario", principal);
        return "index";
    }

}
