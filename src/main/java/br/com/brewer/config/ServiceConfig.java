package br.com.brewer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.com.brewer.service.CervejaService;
import br.com.brewer.storage.FotoStorage;
import br.com.brewer.storage.local.FotoStorageLocal;

@Configuration
@ComponentScan(basePackageClasses = CervejaService.class)
public class ServiceConfig {
	
	@Bean
	public FotoStorage fotoStorage() {
		return new FotoStorageLocal();
	}

}