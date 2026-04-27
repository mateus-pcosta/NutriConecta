package br.com.nutriconecta.nutriconecta.controller;

import br.com.nutriconecta.nutriconecta.model.Doacao;
import br.com.nutriconecta.nutriconecta.model.Solicitacao;
import br.com.nutriconecta.nutriconecta.model.Usuario;
import br.com.nutriconecta.nutriconecta.model.enums.StatusSolicitacao;
import br.com.nutriconecta.nutriconecta.service.DoacaoService;
import br.com.nutriconecta.nutriconecta.service.SolicitacaoService;
import br.com.nutriconecta.nutriconecta.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/solicitacoes")
public class SolicitacaoController {

    private final SolicitacaoService solicitacaoService;
    private final DoacaoService doacaoService;
    private final UsuarioService usuarioService;

    @GetMapping("/solicitar/{idDoacao}/{idInstituicao}")
    public String solicitar(
            @PathVariable Long idDoacao,
            @PathVariable Long idInstituicao
    ) {
        Doacao doacao = doacaoService.buscarPorId(idDoacao);
        Usuario instituicao = usuarioService.buscarPorId(idInstituicao);

        Solicitacao solicitacao = new Solicitacao();
        solicitacao.setDoacao(doacao);
        solicitacao.setInstituicao(instituicao);
        solicitacao.setStatus(StatusSolicitacao.PENDENTE);

        solicitacaoService.salvar(solicitacao);

        return "redirect:/doacoes/detalhes/" + idDoacao;
    }

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("solicitacoes", solicitacaoService.listarTodas());
        return "solicitacoes/lista";
    }

    @GetMapping("/status/{id}/{status}")
    public String alterarStatus(
            @PathVariable Long id,
            @PathVariable StatusSolicitacao status
    ) {
        solicitacaoService.alterarStatus(id, status);
        return "redirect:/solicitacoes/listar";
    }
}
