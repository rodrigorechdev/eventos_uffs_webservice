package com.eventos.uffs.demo.business.UsuariosBusiness;

import com.eventos.uffs.demo.sql.entity.Usuario;
import com.eventos.uffs.demo.sql.repository.UsuarioRepository;
import com.eventos.uffs.demo.exception.UsuarioSemPermissaoException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.eventos.uffs.demo.enums.CargoIdEnum.ADMINISTRADOR;
import static com.eventos.uffs.demo.enums.CargoIdEnum.GESTOR;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/*Business para transformar usuário em gestor */
@Component
public class PromoverParaGestorBusiness {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Autowired
    UsuarioRepository repository;
    
    public void transformaUsuarioEmGestor(Integer idNovoGestor, Integer idSolicitante) throws UsuarioSemPermissaoException {
        var solicitante = repository.findById(idSolicitante);
        if(usuarioIsAdministrador(solicitante)) {
            Usuario novoGestor = repository.findById(idNovoGestor).get();
            entityManager.clear();
            novoGestor.getCargo().setIdCargo(GESTOR.getValor());
            repository.save(novoGestor);
        } else {
            throw new UsuarioSemPermissaoException("Solicitante não é um administrador");
        }
    }

    private Boolean usuarioIsAdministrador(Optional<Usuario> usuario) {
        return usuario.get().getCargo().getIdCargo().equals(ADMINISTRADOR.getValor());
    }
}
