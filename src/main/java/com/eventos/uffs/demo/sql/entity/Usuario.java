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
@Table(name = "usuario")
public class Usuario {
    @Id
    @Column(name = "user_id")
    @GeneratedValue
    private Integer idUsuario;

	@Column(name = "user_nome")
    private String nomeUsuario;

    @Column(name = "user_email")
    private String emailUsuario;

    @Column(name = "user_senha")
    private String senhaUsuario;

    @Column(name = "user_id_cargo")
    private String cargoId;
}