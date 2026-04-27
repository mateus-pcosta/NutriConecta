package br.com.nutriconecta.nutriconecta.controller;

import br.com.nutriconecta.nutriconecta.model.Usuario;
import br.com.nutriconecta.nutriconecta.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping("/novo")
    public String novoUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuarios/form";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Usuario usuario) {
        usuarioService.salvar(usuario);
        return "redirect:/usuarios/listar";
    }

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("usuarios", usuarioService.listarTodos());
        return "usuarios/lista";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("usuario", usuarioService.buscarPorId(id));
        return "usuarios/form";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        usuarioService.deletar(id);
        return "redirect:/usuarios/listar";
    }

}
