package com.eventos.uffs.demo.param;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class ConsultarEventosParam {
    private Integer idEvento;
    private Integer areaConhecimentoId;
    private Integer modalidadeId;
    private Boolean data;
    private Boolean horas;
    private Boolean custo;
}
