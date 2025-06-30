package br.com.brewer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.brewer.model.Cidade;

public interface Cidades extends JpaRepository<Cidade, Long> {

	List<Cidade> findByEstadoCodigo(Long codigoEstado);

}
