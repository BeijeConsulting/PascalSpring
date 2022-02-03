package it.beije.pascal.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the indirizzo database table.
 * 
 */
@Entity
@NamedQuery(name="Indirizzo.findAll", query="SELECT i FROM Indirizzo i")
public class Indirizzo  {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String cap;

	private String comune;

	private String indirizzo;

	@Column(name="n_civico")
	private int nCivico;

	public Indirizzo() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
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
		return this.indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public int getNCivico() {
		return this.nCivico;
	}

	public void setNCivico(int nCivico) {
		this.nCivico = nCivico;
	}

}