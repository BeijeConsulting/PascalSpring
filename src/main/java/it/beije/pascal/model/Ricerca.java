package it.beije.pascal.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the ricerca database table.
 * 
 */
@Entity
@NamedQuery(name="Ricerca.findAll", query="SELECT r FROM Ricerca r")
public class Ricerca  {
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

	@Column(name="bagni_min")
	private String bagniMin;

	private byte balcone;

	@Column(name="classe_energetica")
	private String classeEnergetica;

	private String comune;

	private String condizione;

	private String frazione;

	private String giardino;

	@Column(name="locali_max")
	private int localiMax;

	@Column(name="locali_min")
	private int localiMin;

	@Column(name="mq_max")
	private int mqMax;

	@Column(name="mq_min")
	private int mqMin;

	private String piano;

	private byte piscina;

	private byte portineria;

	@Column(name="posti_auto")
	private String postiAuto;

	@Column(name="prezzo_max")
	private int prezzoMax;

	@Column(name="prezzo_min")
	private int prezzoMin;

	private double raggio;

	private String riscaldamento;

	@Column(name="stato_rogito")
	private String statoRogito;

	private byte terrazzo;

	@Column(name="tipo_annuncio")
	private String tipoAnnuncio;

	@Column(name="tipo_immobile")
	private String tipoImmobile;

	@Column(name="tipo_mappa")
	private String tipoMappa;

	@Column(name="tipo_ricerca")
	private String tipoRicerca;

	@Column(name="ultimo_timestamp")
	private Timestamp ultimoTimestamp;

	@Column(name="virtual_tour")
	private byte virtualTour;

	@Column(name="visita_guidata")
	private byte visitaGuidata;

	//bi-directional many-to-one association to Punto
	@OneToMany(mappedBy="ricerca")
	private List<Punto> puntos;

	//uni-directional many-to-one association to Punto
	@ManyToOne
	@JoinColumn(name="centro_id")
	private Punto punto1;

	//uni-directional many-to-one association to Punto
	@ManyToOne
	@JoinColumn(name="centro_id")
	private Punto punto2;

	//uni-directional many-to-one association to Utente
	@ManyToOne
	private Utente utente;

	public Ricerca() {
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

	public String getBagniMin() {
		return this.bagniMin;
	}

	public void setBagniMin(String bagniMin) {
		this.bagniMin = bagniMin;
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

	public String getComune() {
		return this.comune;
	}

	public void setComune(String comune) {
		this.comune = comune;
	}

	public String getCondizione() {
		return this.condizione;
	}

	public void setCondizione(String condizione) {
		this.condizione = condizione;
	}

	public String getFrazione() {
		return this.frazione;
	}

	public void setFrazione(String frazione) {
		this.frazione = frazione;
	}

	public String getGiardino() {
		return this.giardino;
	}

	public void setGiardino(String giardino) {
		this.giardino = giardino;
	}

	public int getLocaliMax() {
		return this.localiMax;
	}

	public void setLocaliMax(int localiMax) {
		this.localiMax = localiMax;
	}

	public int getLocaliMin() {
		return this.localiMin;
	}

	public void setLocaliMin(int localiMin) {
		this.localiMin = localiMin;
	}

	public int getMqMax() {
		return this.mqMax;
	}

	public void setMqMax(int mqMax) {
		this.mqMax = mqMax;
	}

	public int getMqMin() {
		return this.mqMin;
	}

	public void setMqMin(int mqMin) {
		this.mqMin = mqMin;
	}

	public String getPiano() {
		return this.piano;
	}

	public void setPiano(String piano) {
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

	public String getPostiAuto() {
		return this.postiAuto;
	}

	public void setPostiAuto(String postiAuto) {
		this.postiAuto = postiAuto;
	}

	public int getPrezzoMax() {
		return this.prezzoMax;
	}

	public void setPrezzoMax(int prezzoMax) {
		this.prezzoMax = prezzoMax;
	}

	public int getPrezzoMin() {
		return this.prezzoMin;
	}

	public void setPrezzoMin(int prezzoMin) {
		this.prezzoMin = prezzoMin;
	}

	public double getRaggio() {
		return this.raggio;
	}

	public void setRaggio(double raggio) {
		this.raggio = raggio;
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

	public String getTipoMappa() {
		return this.tipoMappa;
	}

	public void setTipoMappa(String tipoMappa) {
		this.tipoMappa = tipoMappa;
	}

	public String getTipoRicerca() {
		return this.tipoRicerca;
	}

	public void setTipoRicerca(String tipoRicerca) {
		this.tipoRicerca = tipoRicerca;
	}

	public Timestamp getUltimoTimestamp() {
		return this.ultimoTimestamp;
	}

	public void setUltimoTimestamp(Timestamp ultimoTimestamp) {
		this.ultimoTimestamp = ultimoTimestamp;
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

	public List<Punto> getPuntos() {
		return this.puntos;
	}

	public void setPuntos(List<Punto> puntos) {
		this.puntos = puntos;
	}

	public Punto addPunto(Punto punto) {
		getPuntos().add(punto);
		punto.setRicerca(this);

		return punto;
	}

	public Punto removePunto(Punto punto) {
		getPuntos().remove(punto);
		punto.setRicerca(null);

		return punto;
	}

	public Punto getPunto1() {
		return this.punto1;
	}

	public void setPunto1(Punto punto1) {
		this.punto1 = punto1;
	}

	public Punto getPunto2() {
		return this.punto2;
	}

	public void setPunto2(Punto punto2) {
		this.punto2 = punto2;
	}

	public Utente getUtente() {
		return this.utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

}