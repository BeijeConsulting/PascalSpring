package it.beije.pascal.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ricerca_salvata database table.
 * 
 */
@Entity
@Table(name="ricerca_salvata")
@NamedQuery(name="RicercaSalvata.findAll", query="SELECT r FROM RicercaSalvata r")
public class RicercaSalvata  {
	private static final long serialVersionUID = 1L;

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