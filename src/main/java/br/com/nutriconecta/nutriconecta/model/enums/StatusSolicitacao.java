package br.com.nutriconecta.nutriconecta.model.enums;

// Enum que representa o status de uma solicitação feita por uma instituição
public enum StatusSolicitacao {

    // Solicitação feita, aguardando análise do doador
    PENDENTE("Pendente"),

    // Solicitação aprovada pelo doador
    APROVADA("Aprovada"),

    // Solicitação rejeitada pelo doador
    REJEITADA("Rejeitada"),

    // Solicitação cancelada (pela instituição ou sistema)
    CANCELADA("Cancelada");

    // Texto descritivo para exibição
    private final String descricao;

    StatusSolicitacao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}