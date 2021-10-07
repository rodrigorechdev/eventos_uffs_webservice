package com.eventos.uffs.demo.sql.entity;

// import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

// import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cargo")
public class Cargo {
    @Id
    @Column(name = "cargo_id")
    @GeneratedValue
    private Integer idCargo;

	@Column(name = "cargo_nome")
    private String nome;
}