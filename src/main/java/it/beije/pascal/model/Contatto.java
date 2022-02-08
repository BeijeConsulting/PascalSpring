package it.beije.pascal.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/*
CREATE TABLE `rubrica`.`contatti` (
`id` INT NOT NULL AUTO_INCREMENT,
`cognome` VARCHAR(45) NULL,
`nome` VARCHAR(45) NULL,
`telefono` VARCHAR(20) NULL,
`email` VARCHAR(100) NULL,
`note` VARCHAR(200) NULL,
PRIMARY KEY (`id`));
*/


/**
 * The persistent class for the contatti database table.
 * 
 */
@Entity
@Table(name = "contatti")
@JsonInclude(Include.NON_NULL)
public class Contatto {
	
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