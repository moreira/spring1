package br.com.caelum.cadastrao.seguranca;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Grupo implements GrantedAuthority {

	@Id
	@GeneratedValue
	private Long id;
	private String nome;

	// getters e setters

	@Override
	public String getAuthority() {
		return getNome();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}