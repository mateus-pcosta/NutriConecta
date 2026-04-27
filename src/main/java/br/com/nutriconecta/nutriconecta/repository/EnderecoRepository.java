package br.com.nutriconecta.nutriconecta.repository;

import br.com.nutriconecta.nutriconecta.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

// Repositório da entidade Endereco
// Responsável por acessar a tabela "enderecos" no banco de dados
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    // Podemos criar métodos de consulta específicos se necessário,
    // por exemplo: Optional<Endereco> findByUsuarioId(Long idUsuario);
}