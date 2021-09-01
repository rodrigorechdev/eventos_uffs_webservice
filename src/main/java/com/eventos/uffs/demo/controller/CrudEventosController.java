package com.eventos.uffs.demo.controller;

import java.util.Date;

import com.eventos.uffs.demo.sql.entity.Evento;
import com.eventos.uffs.demo.sql.repository.EventoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("eventos")
@RestController
public class CrudEventosController {
    
    @Autowired
    EventoRepository eventoRepository;

    @RequestMapping(value = "create", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	//public ResponseEntity<Boolean> createEventos() {
    public Object createEventos() {
        var evento = new Evento(2, "nome", new Date(), "horario", 233.d);
        return eventoRepository.save(evento);
    }
}
