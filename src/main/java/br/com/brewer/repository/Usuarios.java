package br.com.brewer.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.brewer.model.Usuario;

public interface Usuarios extends JpaRepository<Usuario, Long> {

	Optional<Usuario> findByEmail(String email);

}