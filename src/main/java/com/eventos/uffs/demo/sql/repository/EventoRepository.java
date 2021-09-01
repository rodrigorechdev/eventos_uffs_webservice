package com.eventos.uffs.demo.sql.repository;

import com.eventos.uffs.demo.sql.entity.Evento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer> {
    
    //public <S> Evento save(Evento evento);
}
