package br.com.brewer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.brewer.model.Cliente;
import br.com.brewer.repository.Clientes;
import br.com.brewer.service.exception.CpfCnpjClienteJaCadastradoExcetion;

@Service
public class ClienteService {
	
	@Autowired
	private Clientes clientes;
	
	@Transactional
	public void salvar(Cliente cliente) {
		Optional<Cliente> clienteExistente = clientes.findByCpfOuCnpj(cliente.getCpfOuCnpjSemFormatacao());
		if(clienteExistente.isPresent()) {
			throw new CpfCnpjClienteJaCadastradoExcetion("CPF/CNPJ já cadastrado");
		}
		clientes.save(cliente);
	}

}