package br.com.nutriconecta.nutriconecta.model.enums;

// Enum que representa os possíveis status de uma doação no sistema
public enum StatusDoacao {

    // Doação disponível para ser solicitada
    ABERTA("Aberta"),

    // Doação em processo de retirada/entrega
    EM_ANDAMENTO("Em Andamento"),

    // Doação reservada para uma instituição específica
    RESERVADA("Reservada"),

    // Doação concluída (retirada realizada)
    CONCLUIDA("Concluída"),

    // Doação cancelada (pelo doador ou pelo sistema)
    CANCELADA("Cancelada");

    // Descrição amigável para exibir na tela
    private final String descricao;

    // Construtor do enum (privado por padrão)
    StatusDoacao(String descricao) {
        this.descricao = descricao;
    }

    // Getter para acessar a descrição
    public String getDescricao() {
        return descricao;
    }
}
