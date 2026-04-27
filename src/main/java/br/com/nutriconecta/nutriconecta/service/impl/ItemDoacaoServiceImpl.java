package br.com.nutriconecta.nutriconecta.service.impl;

import br.com.nutriconecta.nutriconecta.model.Doacao;
import br.com.nutriconecta.nutriconecta.model.ItemDoacao;
import br.com.nutriconecta.nutriconecta.repository.ItemDoacaoRepository;
import br.com.nutriconecta.nutriconecta.service.ItemDoacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

// Implementação da lógica de negócio para itens de doação
@Service
@RequiredArgsConstructor
public class ItemDoacaoServiceImpl implements ItemDoacaoService {

    private final ItemDoacaoRepository itemDoacaoRepository;

    // Salva ou atualiza um item de doação
    @Override
    public ItemDoacao salvar(ItemDoacao item) {
        return itemDoacaoRepository.save(item);
    }

    // Lista todos os itens associados a uma doação específica
    @Override
    public List<ItemDoacao> listarPorDoacao(Doacao doacao) {
        return itemDoacaoRepository.findByDoacao(doacao);
    }
}