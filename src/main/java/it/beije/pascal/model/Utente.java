package it.beije.pascal.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the utente database table.
 * 
 */
@Entity
@NamedQuery(name="Utente.findAll", query="SELECT u FROM Utente u")
public class Utente  {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private byte amministratore;

	@Column(name="avatar_url")
	private String avatarUrl;

	@Column(name="commerciale_id")
	private int commercialeId;

	@Column(name="create_timestamp")
	private Timestamp createTimestamp;

	private String email;

	private String password;

	@Column(name="spam_check")
	private byte spamCheck;

	private String username;

	//bi-directional many-to-one association to AnnunciSalvati
	@OneToMany(mappedBy="utente")
	private List<AnnunciSalvati> annunciSalvati;

	//bi-directional many-to-one association to Annuncio
	@OneToMany(mappedBy="utente")
	private List<Annuncio> annunciPubblicati;

	//bi-directional many-to-one association to RicercaSalvata
	@OneToMany(mappedBy="utente")
	private List<RicercaSalvata> ricercheSalvate;

	public Utente() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getAmministratore() {
		return this.amministratore;
	}

	public void setAmministratore(byte amministratore) {
		this.amministratore = amministratore;
	}

	public String getAvatarUrl() {
		return this.avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	public int getCommercialeId() {
		return this.commercialeId;
	}

	public void setCommercialeId(int commercialeId) {
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

	public List<AnnunciSalvati> getAnnunciSalvati() {
		return this.annunciSalvati;
	}

	public void setAnnunciSalvati(List<AnnunciSalvati> annunciSalvati) {
		this.annunciSalvati = annunciSalvati;
	}

	public AnnunciSalvati addAnnunciSalvati(AnnunciSalvati annunciSalvati) {
		getAnnunciSalvati().add(annunciSalvati);
		annunciSalvati.setUtente(this);

		return annunciSalvati;
	}

	public AnnunciSalvati removeAnnunciSalvati(AnnunciSalvati annunciSalvati) {
		getAnnunciSalvati().remove(annunciSalvati);
		annunciSalvati.setUtente(null);

		return annunciSalvati;
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

	public List<RicercaSalvata> getRicercheSalvate() {
		return this.ricercheSalvate;
	}

	public void setRicercheSalvate(List<RicercaSalvata> ricercheSalvate) {
		this.ricercheSalvate = ricercheSalvate;
	}

	public RicercaSalvata addRicercheSalvate(RicercaSalvata ricercheSalvate) {
		getRicercheSalvate().add(ricercheSalvate);
		ricercheSalvate.setUtente(this);

		return ricercheSalvate;
	}

	public RicercaSalvata removeRicercheSalvate(RicercaSalvata ricercheSalvate) {
		getRicercheSalvate().remove(ricercheSalvate);
		ricercheSalvate.setUtente(null);

		return ricercheSalvate;
	}

}