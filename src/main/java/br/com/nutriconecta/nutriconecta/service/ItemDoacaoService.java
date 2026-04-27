package br.com.nutriconecta.nutriconecta.service;

import br.com.nutriconecta.nutriconecta.model.Doacao;
import br.com.nutriconecta.nutriconecta.model.ItemDoacao;

import java.util.List;

// Serviço responsável pela lógica de negócio dos itens de doação
public interface ItemDoacaoService {

    // Salva ou atualiza um item de doação
    ItemDoacao salvar(ItemDoacao item);

    // Lista todos os itens associados a uma determinada doação
    List<ItemDoacao> listarPorDoacao(Doacao doacao);
}