package it.beije.pascal.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 * The persistent class for the utente database table.
 * 
 */
@Entity
@NamedQuery(name = "Utente.findAll", query = "SELECT u FROM Utente u")
public class Utente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Boolean amministratore;

	@Column(name = "avatar_url")
	private String avatarUrl;

	@Column(name="commerciale_id")
	private Integer commercialeId;

	@Column(name = "create_timestamp")
	private Timestamp createTimestamp;

	private String email;

	private String password;

	@Column(name = "spam_check")
	private byte spamCheck;

	private String username;

	@ManyToMany
	@JoinTable(name = "annunci_salvati", joinColumns = @JoinColumn(name = "utente_id"), inverseJoinColumns = @JoinColumn(name = "annuncio_id"))
	private List<Annuncio> annunciSalvati;

	// bi-directional many-to-one association to Annuncio
	@OneToMany(mappedBy = "utente")
	private List<Annuncio> annunciPubblicati;

	// bi-directional many-to-one association to RicercaSalvata
	@ManyToMany
	@JoinTable(name = "ricerca_salvata", joinColumns = @JoinColumn(name = "utente_id"), inverseJoinColumns = @JoinColumn(name = "ricerca_id"))
	private List<Ricerca> ricercheSalvate;

	public Utente() {
	}

	public Utente(String email, String password, byte spamCheck, String username) {
		super();
		this.email = email;
		this.password = password;
		this.spamCheck = spamCheck;
		this.username = username;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getAmministratore() {
		return amministratore;
	}

	public void setAmministratore(Boolean amministratore) {
		this.amministratore = amministratore;
	}

	public void setCommercialeId(Integer commercialeId) {
		this.commercialeId = commercialeId;
	}

	public String getAvatarUrl() {
		return this.avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	public Integer getCommercialeId() {
		return commercialeId;
	}

	public void setCommercialeId(Integer commercialeId) {
		this.commercialeId = commercialeId;
	}

	public Timestamp getCreateTimestamp() {
		return this.createTimestamp;
	}

	public void setCreateTimestamp(Timestamp createTimestamp) {
		this.createTimestamp = createTimestamp;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public byte getSpamCheck() {
		return this.spamCheck;
	}

	public void setSpamCheck(byte spamCheck) {
		this.spamCheck = spamCheck;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Annuncio> getAnnunciPubblicati() {
		return this.annunciPubblicati;
	}

	public void setAnnunciPubblicati(List<Annuncio> annunciPubblicati) {
		this.annunciPubblicati = annunciPubblicati;
	}

	public Annuncio addAnnunciPubblicati(Annuncio annunciPubblicati) {
		getAnnunciPubblicati().add(annunciPubblicati);
		annunciPubblicati.setUtente(this);

		return annunciPubblicati;
	}

	public Annuncio removeAnnunciPubblicati(Annuncio annunciPubblicati) {
		getAnnunciPubblicati().remove(annunciPubblicati);
		annunciPubblicati.setUtente(null);

		return annunciPubblicati;
	}

	public List<Annuncio> getAnnunciSalvati() {
		return annunciSalvati;
	}

	public void setAnnunciSalvati(List<Annuncio> annunciSalvati) {
		this.annunciSalvati = annunciSalvati;
	}

	public List<Ricerca> getRicercheSalvate() {
		return ricercheSalvate;
	}

	public void setRicercheSalvate(List<Ricerca> ricercheSalvate) {
		this.ricercheSalvate = ricercheSalvate;
	}

}