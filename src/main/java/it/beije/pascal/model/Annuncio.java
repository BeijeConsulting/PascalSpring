package it.beije.pascal.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the annuncio database table.
 * 
 */
@Entity
@NamedQuery(name="Annuncio.findAll", query="SELECT a FROM Annuncio a")
public class Annuncio  {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="anno_costruzione")
	private short annoCostruzione;

	@Column(name="aria_condizionata")
	private String ariaCondizionata;

	private String arredamento;

	private byte ascensore;

	private int bagni;

	private byte balcone;

	@Column(name="classe_energetica")
	private String classeEnergetica;

	private String condizione;

	@Column(name="create_timestamp")
	private Timestamp createTimestamp;

	@Lob
	@Column(name="descrizione_lunga")
	private String descrizioneLunga;

	private String giardino;

	private int locali;

	private int mq;

	private int piano;

	private byte piscina;

	private byte portineria;

	@Column(name="posti_auto")
	private int postiAuto;

	private int prezzo;

	private String riscaldamento;

	@Column(name="stato_rogito")
	private String statoRogito;

	private byte terrazzo;

	@Column(name="tipo_annuncio")
	private String tipoAnnuncio;

	@Column(name="tipo_immobile")
	private String tipoImmobile;

	@Column(name="tot_piani")
	private int totPiani;

	@Column(name="virtual_tour")
	private byte virtualTour;

	@Column(name="visita_guidata")
	private byte visitaGuidata;

	//bi-directional many-to-one association to Annuncio
	@ManyToOne
	@JoinColumn(name="edificio_id")
	private Annuncio annuncio;

	//bi-directional many-to-one association to Annuncio
	@OneToMany(mappedBy="annuncio")
	private List<Annuncio> annunciInEdificio;

	//bi-directional many-to-one association to Utente
	@ManyToOne
	@JoinColumn(name="venditore_id")
	private Utente utente;

	//uni-directional many-to-one association to Indirizzo
	@ManyToOne
	private Indirizzo indirizzo;

	//uni-directional many-to-one association to Foto
	@ManyToOne
	@JoinColumn(name="piantina_id")
	private Foto foto;

	//bi-directional many-to-one association to Foto
	@OneToMany(mappedBy="annuncio")
	private List<Foto> fotos;

	public Annuncio() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public short getAnnoCostruzione() {
		return this.annoCostruzione;
	}

	public void setAnnoCostruzione(short annoCostruzione) {
		this.annoCostruzione = annoCostruzione;
	}

	public String getAriaCondizionata() {
		return this.ariaCondizionata;
	}

	public void setAriaCondizionata(String ariaCondizionata) {
		this.ariaCondizionata = ariaCondizionata;
	}

	public String getArredamento() {
		return this.arredamento;
	}

	public void setArredamento(String arredamento) {
		this.arredamento = arredamento;
	}

	public byte getAscensore() {
		return this.ascensore;
	}

	public void setAscensore(byte ascensore) {
		this.ascensore = ascensore;
	}

	public int getBagni() {
		return this.bagni;
	}

	public void setBagni(int bagni) {
		this.bagni = bagni;
	}

	public byte getBalcone() {
		return this.balcone;
	}

	public void setBalcone(byte balcone) {
		this.balcone = balcone;
	}

	public String getClasseEnergetica() {
		return this.classeEnergetica;
	}

	public void setClasseEnergetica(String classeEnergetica) {
		this.classeEnergetica = classeEnergetica;
	}

	public String getCondizione() {
		return this.condizione;
	}

	public void setCondizione(String condizione) {
		this.condizione = condizione;
	}

	public Timestamp getCreateTimestamp() {
		return this.createTimestamp;
	}

	public void setCreateTimestamp(Timestamp createTimestamp) {
		this.createTimestamp = createTimestamp;
	}

	public String getDescrizioneLunga() {
		return this.descrizioneLunga;
	}

	public void setDescrizioneLunga(String descrizioneLunga) {
		this.descrizioneLunga = descrizioneLunga;
	}

	public String getGiardino() {
		return this.giardino;
	}

	public void setGiardino(String giardino) {
		this.giardino = giardino;
	}

	public int getLocali() {
		return this.locali;
	}

	public void setLocali(int locali) {
		this.locali = locali;
	}

	public int getMq() {
		return this.mq;
	}

	public void setMq(int mq) {
		this.mq = mq;
	}

	public int getPiano() {
		return this.piano;
	}

	public void setPiano(int piano) {
		this.piano = piano;
	}

	public byte getPiscina() {
		return this.piscina;
	}

	public void setPiscina(byte piscina) {
		this.piscina = piscina;
	}

	public byte getPortineria() {
		return this.portineria;
	}

	public void setPortineria(byte portineria) {
		this.portineria = portineria;
	}

	public int getPostiAuto() {
		return this.postiAuto;
	}

	public void setPostiAuto(int postiAuto) {
		this.postiAuto = postiAuto;
	}

	public int getPrezzo() {
		return this.prezzo;
	}

	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}

	public String getRiscaldamento() {
		return this.riscaldamento;
	}

	public void setRiscaldamento(String riscaldamento) {
		this.riscaldamento = riscaldamento;
	}

	public String getStatoRogito() {
		return this.statoRogito;
	}

	public void setStatoRogito(String statoRogito) {
		this.statoRogito = statoRogito;
	}

	public byte getTerrazzo() {
		return this.terrazzo;
	}

	public void setTerrazzo(byte terrazzo) {
		this.terrazzo = terrazzo;
	}

	public String getTipoAnnuncio() {
		return this.tipoAnnuncio;
	}

	public void setTipoAnnuncio(String tipoAnnuncio) {
		this.tipoAnnuncio = tipoAnnuncio;
	}

	public String getTipoImmobile() {
		return this.tipoImmobile;
	}

	public void setTipoImmobile(String tipoImmobile) {
		this.tipoImmobile = tipoImmobile;
	}

	public int getTotPiani() {
		return this.totPiani;
	}

	public void setTotPiani(int totPiani) {
		this.totPiani = totPiani;
	}

	public byte getVirtualTour() {
		return this.virtualTour;
	}

	public void setVirtualTour(byte virtualTour) {
		this.virtualTour = virtualTour;
	}

	public byte getVisitaGuidata() {
		return this.visitaGuidata;
	}

	public void setVisitaGuidata(byte visitaGuidata) {
		this.visitaGuidata = visitaGuidata;
	}

	public Annuncio getAnnuncio() {
		return this.annuncio;
	}

	public void setAnnuncio(Annuncio annuncio) {
		this.annuncio = annuncio;
	}

	public List<Annuncio> getAnnunciInEdificio() {
		return this.annunciInEdificio;
	}

	public void setAnnunciInEdificio(List<Annuncio> annunciInEdificio) {
		this.annunciInEdificio = annunciInEdificio;
	}

	public Annuncio addAnnunciInEdificio(Annuncio annunciInEdificio) {
		getAnnunciInEdificio().add(annunciInEdificio);
		annunciInEdificio.setAnnuncio(this);

		return annunciInEdificio;
	}

	public Annuncio removeAnnunciInEdificio(Annuncio annunciInEdificio) {
		getAnnunciInEdificio().remove(annunciInEdificio);
		annunciInEdificio.setAnnuncio(null);

		return annunciInEdificio;
	}

	public Utente getUtente() {
		return this.utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public Indirizzo getIndirizzo() {
		return this.indirizzo;
	}

	public void setIndirizzo(Indirizzo indirizzo) {
		this.indirizzo = indirizzo;
	}

	public Foto getFoto() {
		return this.foto;
	}

	public void setFoto(Foto foto) {
		this.foto = foto;
	}

	public List<Foto> getFotos() {
		return this.fotos;
	}

	public void setFotos(List<Foto> fotos) {
		this.fotos = fotos;
	}

	public Foto addFoto(Foto foto) {
		getFotos().add(foto);
		foto.setAnnuncio(this);

		return foto;
	}

	public Foto removeFoto(Foto foto) {
		getFotos().remove(foto);
		foto.setAnnuncio(null);

		return foto;
	}

}