package com.eventos.uffs.demo.controller;

import com.eventos.uffs.demo.business.UsuariosBusiness.PromoverParaGestorBusiness;
import com.eventos.uffs.demo.exception.UsuarioSemPermissaoException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("usuario")
@RestController
@CrossOrigin(origins = "*")
public class UsuariosController {

    @Autowired
    PromoverParaGestorBusiness promoverParaGestorBusiness;

    /**
     * transforma usuário com id recebido no Path em gestor. Antes disso analisa 
     * se o usuário solicitante tem permissão para transformar outros usuários em gestor
     */
    @RequestMapping(value = "/{id}/gestor", method = RequestMethod.PATCH, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateEventos(@PathVariable Integer id, @RequestHeader Integer idUsuarioSolicitante) { 
            try {
                promoverParaGestorBusiness.transformaUsuarioEmGestor(id, idUsuarioSolicitante);
            } catch(UsuarioSemPermissaoException e) {
                return new ResponseEntity<>(e.getMessage(), HttpStatus.PRECONDITION_FAILED);
            }
            return new ResponseEntity<>("Usuário promovido para gestor com sucesso!", HttpStatus.NO_CONTENT);
    }

}
