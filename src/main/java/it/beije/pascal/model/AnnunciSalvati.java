package it.beije.pascal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * The persistent class for the annunci_salvati database table.
 * 
 */
@Entity
@Table(name="annunci_salvati")
@NamedQuery(name="AnnunciSalvati.findAll", query="SELECT a FROM AnnunciSalvati a")
public class AnnunciSalvati  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="annuncio_id")
	private int annuncioId;

	@Lob
	private String commento;

	//bi-directional many-to-one association to Utente 
	@ManyToOne
	private Utente utente;

	//uni-directional one-to-one association to Annuncio
	@OneToOne
	private Annuncio annuncio;

	public AnnunciSalvati() {
	}

	public int getAnnuncioId() {
		return this.annuncioId;
	}

	public void setAnnuncioId(int annuncioId) {
		this.annuncioId = annuncioId;
	}

	public String getCommento() {
		return this.commento;
	}

	public void setCommento(String commento) {
		this.commento = commento;
	}

	public Utente getUtente() {
		return this.utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public Annuncio getAnnuncio() {
		return this.annuncio;
	}

	public void setAnnuncio(Annuncio annuncio) {
		this.annuncio = annuncio;
	}

}