package it.beije.pascal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the agenzia database table.
 * 
 */
@Entity
@NamedQuery(name="Agenzia.findAll", query="SELECT a FROM Agenzia a")
public class Agenzia  {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String nome;

	public Agenzia() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}