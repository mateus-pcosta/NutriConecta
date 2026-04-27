package br.com.nutriconecta.nutriconecta.repository;

import br.com.nutriconecta.nutriconecta.model.Doacao;
import br.com.nutriconecta.nutriconecta.model.ItemDoacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// Repositório da entidade ItemDoacao
// Cada ItemDoacao representa um alimento específico dentro de uma doação
public interface ItemDoacaoRepository extends JpaRepository<ItemDoacao, Long> {

    // Busca todos os itens associados a uma determinada doação
    // O Spring Data JPA cria a query automaticamente com base no nome do método
    List<ItemDoacao> findByDoacao(Doacao doacao);
}