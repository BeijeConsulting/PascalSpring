package it.beije.pascal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the commerciale database table. Il campo manager_id
 * riferisce ad Utente, e un utente può registrare un commerciale
 */
@Entity
@NamedQuery(name = "Commerciale.findAll", query = "SELECT c FROM Commerciale c")
@Table(name = "commerciale")
public class Commerciale {

	@Column(name = "cognome_ref")
	private String cognomeRef;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nome_ref")
	private String nomeRef;

	@Column(name = "p_iva")
	private String pIva;

	@Column(name = "ragione_sociale")
	private String ragioneSociale;

	private String telefono;

	private String email;

	private String password;

	// uni-directional many-to-one association to Indirizzo
	@ManyToOne
	private Indirizzo indirizzo;

	public Commerciale() {
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCognomeRef() {
		return this.cognomeRef;
	}

	public void setCognomeRef(String cognomeRef) {
		this.cognomeRef = cognomeRef;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getpIva() {
		return pIva;
	}

	public void setpIva(String pIva) {
		this.pIva = pIva;
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