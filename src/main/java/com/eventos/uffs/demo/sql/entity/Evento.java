package com.eventos.uffs.demo.sql.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "evento")
public class Evento {
    
    @Id
    @Column(name = "ev_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEvento;

	@Column(name = "ev_nome")
    private String nome;

	@Column(name = "ev_data")
    private Date data = new Date();

	@Column(name = "ev_horario")
    private String horario;

    @Column(name = "ev_quantidade_horas")
    private Double quantidadeHoras;

    @Nullable
    @Column(name = "ev_custo")
    private Double custo;

    @ManyToOne
	@JoinColumn(name = "mod_id")
    private Modalidade modalidade;

    @ManyToOne
	@JoinColumn(name = "area_id")
    private AreaConhecimento areaConhecimento;
    
}
