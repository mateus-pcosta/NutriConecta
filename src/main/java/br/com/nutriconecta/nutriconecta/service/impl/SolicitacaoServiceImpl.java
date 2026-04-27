package br.com.nutriconecta.nutriconecta.service.impl;

import br.com.nutriconecta.nutriconecta.model.Doacao;
import br.com.nutriconecta.nutriconecta.model.Solicitacao;
import br.com.nutriconecta.nutriconecta.model.Usuario;
import br.com.nutriconecta.nutriconecta.model.enums.StatusSolicitacao;
import br.com.nutriconecta.nutriconecta.repository.SolicitacaoRepository;
import br.com.nutriconecta.nutriconecta.service.SolicitacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

// Implementação da lógica de negócio para solicitações de doação
@Service
@RequiredArgsConstructor
public class SolicitacaoServiceImpl implements SolicitacaoService {

    private final SolicitacaoRepository repository;

    // Salva uma nova solicitação, sempre começando com status PENDENTE
    @Override
    public Solicitacao salvar(Solicitacao solicitacao) {
        solicitacao.setStatus(StatusSolicitacao.PENDENTE);
        return repository.save(solicitacao);
    }

    // Lista todas as solicitações cadastradas
    @Override
    public List<Solicitacao> listarTodas() {
        return repository.findAll();
    }

    // Lista solicitações feitas por uma instituição específica
    @Override
    public List<Solicitacao> listarPorInstituicao(Usuario instituicao) {
        return repository.findByInstituicao(instituicao);
    }

    // Lista solicitações relacionadas a uma doação específica
    @Override
    public List<Solicitacao> listarPorDoacao(Doacao doacao) {
        return repository.findByDoacao(doacao);
    }

    // Altera o status de uma solicitação e salva a alteração
    @Override
    public Solicitacao alterarStatus(Long id, StatusSolicitacao status) {
        // Busca a solicitação, lança exceção se não encontrar
        Solicitacao solicitacao = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Solicitação não encontrada"));

        // Atualiza o status e salva
        solicitacao.setStatus(status);
        return repository.save(solicitacao);
    }
}