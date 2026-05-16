package br.com.nutriconecta.nutriconecta.service;

import br.com.nutriconecta.nutriconecta.model.Endereco;

import java.util.List;

public interface EnderecoService {
    Endereco salvar(Endereco endereco);
    Endereco buscarPorId(Long id);
    List<Endereco> listarPorUsuario(Long idUsuario);
    void deletar(Long id);
}
