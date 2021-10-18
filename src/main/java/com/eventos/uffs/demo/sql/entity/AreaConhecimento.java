package com.eventos.uffs.demo.sql.entity;

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
@Table(name = "area_conhecimento")
public class AreaConhecimento {
    
    @Id
    @Column(name = "area_id")
    @GeneratedValue
    private Integer idArea;

	@Column(name = "area_nome")
    private String nome;
}
