package br.com.brewer.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.brewer.model.Cliente;

public interface Clientes extends JpaRepository<Cliente, Long>{

	Optional<Cliente> findByCpfOuCnpj(String cpfOuCnpjSemFormatacao);

}
