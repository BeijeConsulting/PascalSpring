package it.beije.pascal.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the commerciale database table.
 * 
 */
@Entity
@NamedQuery(name="Commerciale.findAll", query="SELECT c FROM Commerciale c")
public class Commerciale  {

	@Column(name="cognome_ref")
	private String cognomeRef;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="nome_ref")
	private String nomeRef;

	@Column(name="p_iva")
	private String pIva;

	@Column(name="ragione_sociale")
	private String ragioneSociale;

	private String telefono;

	//uni-directional many-to-one association to Indirizzo
	@ManyToOne
	private Indirizzo indirizzo;

	public Commerciale() {
	}

	public String getCognomeRef() {
		return this.cognomeRef;
	}

	public void setCognomeRef(String cognomeRef) {
		this.cognomeRef = cognomeRef;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeRef() {
		return this.nomeRef;
	}

	public void setNomeRef(String nomeRef) {
		this.nomeRef = nomeRef;
	}

	public String getPIva() {
		return this.pIva;
	}

	public void setPIva(String pIva) {
		this.pIva = pIva;
	}

	public String getRagioneSociale() {
		return this.ragioneSociale;
	}

	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Indirizzo getIndirizzo() {
		return this.indirizzo;
	}

	public void setIndirizzo(Indirizzo indirizzo) {
		this.indirizzo = indirizzo;
	}

}