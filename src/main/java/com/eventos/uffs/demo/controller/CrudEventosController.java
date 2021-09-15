package com.eventos.uffs.demo.controller;

import com.eventos.uffs.demo.sql.entity.Evento;
import com.eventos.uffs.demo.sql.repository.EventoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RequestMapping("eventos")
@RestController
@CrossOrigin(origins = "*")
public class CrudEventosController {
    
    @Autowired
    EventoRepository eventoRepository;

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Evento> createEventos(@RequestBody Evento evento) {
            Evento eventoSalvo =  eventoRepository.save(evento);
            return new ResponseEntity<>(eventoSalvo, HttpStatus.CREATED);
    }
}
