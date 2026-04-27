package br.com.nutriconecta.nutriconecta.controller;

import br.com.nutriconecta.nutriconecta.dto.EstatisticasDTO;
import br.com.nutriconecta.nutriconecta.service.DoacaoService;
import br.com.nutriconecta.nutriconecta.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final DoacaoService doacaoService;
    private final UsuarioService usuarioService;

    @GetMapping("/")
    public String index(Model model) {

        EstatisticasDTO estatisticas = new EstatisticasDTO(
                doacaoService.count(),                 // total de doações
                usuarioService.countInstituicoes(),    // total de instituições
                doacaoService.totalAlimentosDistribuidos() // total de alimentos
        );

        model.addAttribute("estatisticas", estatisticas);

        return "index";
    }
}
