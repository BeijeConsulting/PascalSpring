package it.beije.pascal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * The persistent class for the ricerca_salvata database table.
 * 
 */
@Entity
@Table(name="ricerca_salvata")
@NamedQuery(name="RicercaSalvata.findAll", query="SELECT r FROM RicercaSalvata r")
public class RicercaSalvata  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ricerca_id")
	private int ricercaId;

	//uni-directional one-to-one association to Ricerca
	@OneToOne
	private Ricerca ricerca;

	//bi-directional many-to-one association to Utente
	@ManyToOne
	private Utente utente;

	public RicercaSalvata() {
	}

	public int getRicercaId() {
		return this.ricercaId;
	}

	public void setRicercaId(int ricercaId) {
		this.ricercaId = ricercaId;
	}

	public Ricerca getRicerca() {
		return this.ricerca;
	}

	public void setRicerca(Ricerca ricerca) {
		this.ricerca = ricerca;
	}

	public Utente getUtente() {
		return this.utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

}