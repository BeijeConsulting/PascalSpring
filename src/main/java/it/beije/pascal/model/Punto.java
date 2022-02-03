package it.beije.pascal.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the punto database table.
 * 
 */
@Entity
@NamedQuery(name="Punto.findAll", query="SELECT p FROM Punto p")
public class Punto  {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private double latitudine;

	private double longitudine;

	//bi-directional many-to-one association to Ricerca
	@ManyToOne
	private Ricerca ricerca;

	public Punto() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getLatitudine() {
		return this.latitudine;
	}

	public void setLatitudine(double latitudine) {
		this.latitudine = latitudine;
	}

	public double getLongitudine() {
		return this.longitudine;
	}

	public void setLongitudine(double longitudine) {
		this.longitudine = longitudine;
	}

	public Ricerca getRicerca() {
		return this.ricerca;
	}

	public void setRicerca(Ricerca ricerca) {
		this.ricerca = ricerca;
	}

}