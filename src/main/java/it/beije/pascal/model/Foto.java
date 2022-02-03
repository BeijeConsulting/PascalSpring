package it.beije.pascal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the foto database table.
 * 
 */
@Entity
@NamedQuery(name="Foto.findAll", query="SELECT f FROM Foto f")
public class Foto  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String url;

	//bi-directional many-to-one association to Annuncio
	@ManyToOne
	private Annuncio annuncio;

	public Foto() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Annuncio getAnnuncio() {
		return this.annuncio;
	}

	public void setAnnuncio(Annuncio annuncio) {
		this.annuncio = annuncio;
	}

}