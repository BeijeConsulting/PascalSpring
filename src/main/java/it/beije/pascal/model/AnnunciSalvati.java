package it.beije.pascal.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the annunci_salvati database table.
 * 
 */
@Entity
@Table(name="annunci_salvati")
@NamedQuery(name="AnnunciSalvati.findAll", query="SELECT a FROM AnnunciSalvati a")
public class AnnunciSalvati  {
	private static final long serialVersionUID = 1L;

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