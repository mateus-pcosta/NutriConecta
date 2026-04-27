package br.com.nutriconecta.nutriconecta.service.impl;

import br.com.nutriconecta.nutriconecta.model.Doacao;
import br.com.nutriconecta.nutriconecta.model.Usuario;
import br.com.nutriconecta.nutriconecta.model.enums.StatusDoacao;
import br.com.nutriconecta.nutriconecta.repository.DoacaoRepository;
import br.com.nutriconecta.nutriconecta.service.DoacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

// Implementação da lógica de negócio para doações
@Service
@RequiredArgsConstructor
public class DoacaoServiceImpl implements DoacaoService {

    private final DoacaoRepository doacaoRepository;

    // Conta quantas doações existem no sistema
    @Override
    public long count() {
        return doacaoRepository.count();
    }

    // Retorna o total de alimentos distribuídos
    // A lógica dessa soma está implementada no DoacaoRepository (método customizado)
    @Override
    public long totalAlimentosDistribuidos() {
        return doacaoRepository.totalAlimentosDistribuidos();
    }

    // Salva ou atualiza uma doação
    @Override
    public Doacao salvar(Doacao doacao) {
        return doacaoRepository.save(doacao);
    }

    // Busca uma doação pelo ID, lança exceção se não encontrar
    @Override
    public Doacao buscarPorId(Long id) {
        return doacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doação não encontrada"));
    }

    // Lista todas as doações cadastradas
    @Override
    public List<Doacao> listarTodas() {
        return doacaoRepository.findAll();
    }

    // Lista as doações feitas por um doador específico
    @Override
    public List<Doacao> listarPorDoador(Usuario doador) {
        return doacaoRepository.findByDoador(doador);
    }

    // Altera o status de uma doação e salva a alteração
    @Override
    public void alterarStatus(Long id, StatusDoacao status) {
        Doacao doacao = buscarPorId(id); // Reaproveita o método buscarPorId
        doacao.setStatus(status);
        doacaoRepository.save(doacao);
    }
}