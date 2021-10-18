package com.eventos.uffs.demo.business.CrudEventosBusiness;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Comparator;

import com.eventos.uffs.demo.param.ConsultarEventosParam;
import com.eventos.uffs.demo.sql.entity.Evento;
import com.eventos.uffs.demo.sql.repository.EventoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ConsultarEventosBusiness {
    
    @Autowired
    EventoRepository eventoRepository;
    
    public ResponseEntity<List<Evento>> consultaFiltradaEventos(ConsultarEventosParam param) {
        List<Evento> eventos = eventoRepository.findAll();

        if(eventos.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        } 

        eventos = this.filtrar(eventos, param);
        eventos = this.ordenar(eventos, param);

        return new ResponseEntity<>(eventos, HttpStatus.OK);
    }

    private List<Evento> filtrar(List<Evento> eventos, ConsultarEventosParam param) {
        if(param.getIdEvento() != null) {
            eventos = eventos.stream()
            .filter(evento -> param.getIdEvento()==evento.getIdEvento())
            .collect(Collectors.toList());
        }
        if(param.getAreaConhecimentoId() != null) {
            eventos = eventos.stream()
                        .filter(evento -> param.getAreaConhecimentoId()==evento.getAreaConhecimento().getIdArea())
                        .collect(Collectors.toList());
        }
        if(param.getModalidadeId() != null) {
            eventos = eventos.stream()
                        .filter(evento -> param.getModalidadeId().equals(evento.getModalidade().getIdModalidade()))
                        .collect(Collectors.toList());
        }

        return eventos;
    }

    private List<Evento> ordenar(List<Evento> eventos, ConsultarEventosParam param) {
        if(param.getData()) {
            eventos = eventos.stream()
            .sorted(Comparator.comparing(Evento::getData))
            .collect(Collectors.toList());
        }
        if(param.getHoras()) {
            eventos = eventos.stream()
            .sorted(Comparator.comparingDouble(Evento::getQuantidadeHoras))
            .collect(Collectors.toList());
        }
        if(param.getCusto()) {
            eventos = eventos.stream()
                        .sorted(Comparator.comparingDouble(Evento::getCusto))
                        .collect(Collectors.toList());
        }
        return eventos;
    }
}
