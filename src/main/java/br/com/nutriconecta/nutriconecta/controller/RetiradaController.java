package br.com.nutriconecta.nutriconecta.controller;

import br.com.nutriconecta.nutriconecta.model.Retirada;
import br.com.nutriconecta.nutriconecta.model.Solicitacao;
import br.com.nutriconecta.nutriconecta.service.RetiradaService;
import br.com.nutriconecta.nutriconecta.service.SolicitacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/retiradas")
public class RetiradaController {

    private final RetiradaService retiradaService;
    private final SolicitacaoService solicitacaoService;

    @GetMapping("/registrar/{idSolicitacao}")
    public String registrar(@PathVariable Long idSolicitacao, Model model) {
        Solicitacao solicitacao = solicitacaoService.listarPorDoacao(null)
                .stream()
                .filter(s -> s.getId().equals(idSolicitacao))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Solicitação não encontrada"));

        Retirada retirada = new Retirada();
        retirada.setSolicitacao(solicitacao);

        model.addAttribute("retirada", retirada);
        return "retiradas/form";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Retirada retirada) {
        retiradaService.registrar(retirada);
        return "redirect:/solicitacoes/listar";
    }

}
