package br.com.caelum.cadastrao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.caelum.cadastrao.infra.ContatoDAO;
import br.com.caelum.cadastrao.modelo.Contato;

@Controller
@Transactional
public class ContatoController {

	@Autowired
	private ContatoDAO dao;

	@RequestMapping("/contatos")
	public ModelAndView form() {
		ModelAndView mav = initModelAndView();
		return mav;
	}

	@RequestMapping("/adicionar")
	public ModelAndView adicionar(Contato contato) {
		dao.salva(contato);
		ModelAndView mav = initModelAndView();
		return mav;
	}

	@RequestMapping("/remover")
	public ModelAndView remover(Contato contato) {
		dao.remove(contato);
		ModelAndView mav = initModelAndView();
		return mav;
	}

	private ModelAndView initModelAndView() {
		ModelAndView mav = new ModelAndView("contatos");
		List<Contato> lista = dao.lista();
		mav.addObject("contatos", lista);
		return mav;
	}

}
