package br.com.caelum.cadastrao.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.xml.MarshallingView;

import br.com.caelum.cadastrao.infra.ContatoDAO;
import br.com.caelum.cadastrao.modelo.Contato;

@Controller
public class ContatoResource {

	@Autowired
	private ContatoDAO dao;

	@RequestMapping(value = "/contatos/{id}", produces = {"application/xml","application/json"}, method=RequestMethod.GET)
	@ResponseBody
	public Contato load(@PathVariable("id") Long id) {
		return dao.busca(id);
	}
}
