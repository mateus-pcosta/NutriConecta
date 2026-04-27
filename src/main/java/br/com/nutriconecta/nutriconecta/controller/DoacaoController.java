package br.com.nutriconecta.nutriconecta.controller;

import br.com.nutriconecta.nutriconecta.model.Doacao;
import br.com.nutriconecta.nutriconecta.model.enums.StatusDoacao;
import br.com.nutriconecta.nutriconecta.service.DoacaoService;
import br.com.nutriconecta.nutriconecta.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/doacoes")
public class DoacaoController {

    private final DoacaoService doacaoService;
    private final UsuarioService usuarioService;

    @GetMapping("/nova")
    public String novaDoacao(Model model) {
        model.addAttribute("doacao", new Doacao());
        model.addAttribute("doadores", usuarioService.listarTodos());
        model.addAttribute("statusList", StatusDoacao.values());
        return "doacoes/form";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Doacao doacao) {
        doacaoService.salvar(doacao);
        return "redirect:/doacoes/listar";
    }

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("doacoes", doacaoService.listarTodas());
        return "doacoes/lista";
    }

    @GetMapping("/detalhes/{id}")
    public String detalhes(@PathVariable Long id, Model model) {
        model.addAttribute("doacao", doacaoService.buscarPorId(id));
        return "doacoes/detalhes";
    }

    @GetMapping("/status/{id}/{status}")
    public String alterarStatus(@PathVariable Long id, @PathVariable StatusDoacao status) {
        doacaoService.alterarStatus(id, status);
        return "redirect:/doacoes/listar";
    }

    @PostMapping("/alterar-status")
    public String alterarStatus(@RequestParam Long id, @RequestParam String status) {

        Doacao doacao = doacaoService.buscarPorId(id);
        doacao.setStatus(StatusDoacao.valueOf(status));
        doacaoService.salvar(doacao);

        return "redirect:/doacoes/listar";
    }

}
