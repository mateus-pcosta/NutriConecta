package br.com.nutriconecta.nutriconecta.controller;

import br.com.nutriconecta.nutriconecta.model.Endereco;
import br.com.nutriconecta.nutriconecta.service.EnderecoService;
import br.com.nutriconecta.nutriconecta.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/enderecos")
public class EnderecoController {

    private final EnderecoService enderecoService;
    private final UsuarioService usuarioService;

    @GetMapping("/listar/{idUsuario}")
    public String listar(@PathVariable Long idUsuario, Model model) {
        model.addAttribute("enderecos", enderecoService.listarPorUsuario(idUsuario));
        model.addAttribute("usuario", usuarioService.buscarPorId(idUsuario));
        return "enderecos/lista";
    }

    @GetMapping("/novo/{idUsuario}")
    public String novo(@PathVariable Long idUsuario, Model model) {
        Endereco endereco = new Endereco();
        endereco.setUsuario(usuarioService.buscarPorId(idUsuario));
        model.addAttribute("endereco", endereco);
        return "enderecos/form";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Endereco endereco) {
        enderecoService.salvar(endereco);
        return "redirect:/enderecos/listar/" + endereco.getUsuario().getId();
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("endereco", enderecoService.buscarPorId(id));
        return "enderecos/form";
    }

    @GetMapping("/deletar/{id}/{idUsuario}")
    public String deletar(@PathVariable Long id, @PathVariable Long idUsuario) {
        enderecoService.deletar(id);
        return "redirect:/enderecos/listar/" + idUsuario;
    }
}
