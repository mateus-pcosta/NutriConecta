package br.com.nutriconecta.nutriconecta.repository;

import br.com.nutriconecta.nutriconecta.model.Alimento;
import org.springframework.data.jpa.repository.JpaRepository;

// Interface de repositório para a entidade Alimento
// JpaRepository já fornece métodos prontos: save, findById, findAll, delete, etc.
public interface AlimentoRepository extends JpaRepository<Alimento, Long> {
    // Não há métodos personalizados aqui ainda.
    // Podemos adicionar depois, por exemplo: List<Alimento> findByCategoria(String categoria);
}