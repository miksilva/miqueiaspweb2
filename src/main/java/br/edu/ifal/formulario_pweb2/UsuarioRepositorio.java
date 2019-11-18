package br.edu.ifal.formulario_pweb2;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepositorio extends CrudRepository<Usuario, Long>{
    List<Usuario> findByNomeContaining(String nome);
}