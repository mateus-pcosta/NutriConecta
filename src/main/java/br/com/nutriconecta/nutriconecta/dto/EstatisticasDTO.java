package br.com.nutriconecta.nutriconecta.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstatisticasDTO {

    private long totalDoacoes;
    private long totalInstituicoes;
    private long totalAlimentos; // em kg, se preferir
}
