package com.eventos.uffs.demo.sql.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "evento")
public class Evento {
    
    @Id
    @Column(name ="ev_id")
    @GeneratedValue
    private Integer idEvento;

	@Column(name ="ev_nome")
    private String nome;

	@Column(name ="ev_data")
    private Date data;

	@Column(name ="ev_horas")
	private String horario;

    @Column(name ="ev_custo")
    private Double custo;
}
