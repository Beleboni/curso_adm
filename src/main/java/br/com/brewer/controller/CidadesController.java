package br.com.brewer.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.brewer.model.Cidade;
import br.com.brewer.repository.Cidades;
import br.com.brewer.repository.filter.CidadeFilter;

@Controller
@RequestMapping("/cidades")
public class CidadesController {
	
	@Autowired
	private Cidades cidades;
	
	@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Cidade> pesquisarPorCodigoEstado(@RequestParam(name = "estado", 
			defaultValue = "-1") Long codigoEstado){
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) { }
		
		return cidades.findByEstadoCodigo(codigoEstado);
		
	}
	
	@GetMapping
	public ModelAndView pesquisar(CidadeFilter filter) {
		ModelAndView mv = new ModelAndView("cidade/PesquisaCidades");
		return mv;
	}

}
