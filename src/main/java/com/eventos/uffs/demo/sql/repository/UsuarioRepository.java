package com.eventos.uffs.demo.sql.repository;

import com.eventos.uffs.demo.sql.entity.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    
}
