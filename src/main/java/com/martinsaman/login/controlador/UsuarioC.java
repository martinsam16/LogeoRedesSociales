package com.martinsaman.login.controlador;

import com.martinsaman.login.modelo.Usuario;
import com.martinsaman.login.repo.IUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class UsuarioC {

    @Autowired
    IUsuario usuarioRepo;

    @GetMapping
    public String home (Model model, Principal principal) {
        model.addAttribute("titulo","Home");
        model.addAttribute("usuario", principal);
        model.addAttribute("usuarios",usuarioRepo.findAll());
        return "index";
    }

    @PostMapping("usuario/agregar/{nombres}/{email}")
    public String agregarUsuario(@PathVariable(name = "nombres") String nombres, @PathVariable(name = "email") String email){
        Optional<Usuario> usuario = usuarioRepo.findOneByEmail(email);
        if (!usuario.isPresent()){
            usuarioRepo.save(new Usuario(email, nombres));
        }
        return "redirect:/";
    }

}
