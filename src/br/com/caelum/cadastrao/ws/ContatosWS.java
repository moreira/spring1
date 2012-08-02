package br.com.caelum.cadastrao.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import br.com.caelum.cadastrao.infra.ContatoDAO;
import br.com.caelum.cadastrao.modelo.Contato;

@WebService
public class ContatosWS extends SpringBeanAutowiringSupport{
	
	@Autowired
	private ContatoDAO dao;
	
	@WebMethod
	public List<Contato> listaDeContatos(){
		if(dao==null){
			processInjectionBasedOnCurrentContext(this);
		}
		return dao.lista();
	}

}
