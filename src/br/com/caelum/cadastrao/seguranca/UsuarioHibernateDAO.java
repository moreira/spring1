package br.com.caelum.cadastrao.seguranca;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioHibernateDAO implements UsuarioDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {
		Query query = entityManager.createQuery("from Usuario where login = :login");
		query.setParameter("login", username);
		List<UserDetails> resultList = query.getResultList();
		if(resultList.size() == 1){
			return resultList.get(0);
		}
		throw new IllegalArgumentException("Problemas ao buscar o usuario "+username);
	}

}