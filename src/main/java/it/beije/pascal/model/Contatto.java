package it.beije.pascal.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the contatti database table.
 * 
 */
@Entity
@Table(name="contatti")
@NamedQuery(name="Contatti.findAll", query="SELECT c FROM Contatto c")
public class Contatto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String cognome;

	private String email;

	private String nome;

	private String note;

	private String telefono;

	public Contatto() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCognome() {
		return this.cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}