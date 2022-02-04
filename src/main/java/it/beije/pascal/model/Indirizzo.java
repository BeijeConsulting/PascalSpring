package it.beije.pascal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the indirizzo database table.
 * 
 */
@Entity
@NamedQuery(name = "Indirizzo.findAll", query = "SELECT i FROM Indirizzo i")
public class Indirizzo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String cap;

	private String comune;

	private String indirizzo;

	@Column(name = "n_civico")
	private Integer nCivico;

	public Indirizzo() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCap() {
		return this.cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getComune() {
		return this.comune;
	}

	public void setComune(String comune) {
		this.comune = comune;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public Integer getnCivico() {
		return nCivico;
	}

	public void setnCivico(Integer nCivico) {
		this.nCivico = nCivico;
	}


	public int getNCivico() {
		return this.nCivico;
	}

	public void setNCivico(int nCivico) {
		this.nCivico = nCivico;
	}

}