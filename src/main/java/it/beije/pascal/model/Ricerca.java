package it.beije.pascal.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import it.beije.pascal.model.enums.AriaCondizionata;
import it.beije.pascal.model.enums.ClasseEnergetica;
import it.beije.pascal.model.enums.Condizione;
import it.beije.pascal.model.enums.Riscaldamento;
import it.beije.pascal.model.enums.StatoRogito;
import it.beije.pascal.model.enums.TipoAnnuncio;
import it.beije.pascal.model.enums.TipoImmobile;
import it.beije.pascal.model.enums.TipoMappa;
import it.beije.pascal.model.enums.TipoRicerca;


/**
 * The persistent class for the ricerca database table.
 * 
 */
@Entity
@NamedQuery(name="Ricerca.findAll", query="SELECT r FROM Ricerca r")
public class Ricerca  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToMany(mappedBy = "ricercheSalvate")
	private List<Utente> salvatoDa;

	@Column(name="anno_costruzione")
	private short annoCostruzione;

	@Enumerated(EnumType.STRING)
	@Column(name="aria_condizionata")
	private AriaCondizionata ariaCondizionata;

	private String arredamento;

	private byte ascensore;

	@Column(name="bagni_min")
	private String bagniMin;

	private byte balcone;

	@Enumerated(EnumType.STRING)
	@Column(name="classe_energetica")
	private ClasseEnergetica classeEnergetica;

	private String comune;

	@Enumerated(EnumType.STRING)
	private Condizione condizione;

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

	@Enumerated(EnumType.STRING)
	private Riscaldamento riscaldamento;

	@Enumerated(EnumType.STRING)
	@Column(name="stato_rogito")
	private StatoRogito statoRogito;

	private byte terrazzo;

	@Enumerated(EnumType.STRING)
	@Column(name="tipo_annuncio")
	private TipoAnnuncio tipoAnnuncio;

	@Enumerated(EnumType.STRING)
	@Column(name="tipo_immobile")
	private TipoImmobile tipoImmobile;

	@Enumerated(EnumType.STRING)
	@Column(name="tipo_mappa")
	private TipoMappa tipoMappa;

	@Enumerated(EnumType.STRING)
	@Column(name="tipo_ricerca")
	private TipoRicerca tipoRicerca;

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
	private Punto centro;

	//uni-directional many-to-one association to Utente
	@ManyToOne
	private Utente utente;

	public Ricerca() {
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


	public Punto getCentro() {
		return centro;
	}


	public void setCentro(Punto centro) {
		this.centro = centro;
	}


	public Utente getUtente() {
		return this.utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public short getAnnoCostruzione() {
		return annoCostruzione;
	}


	public void setAnnoCostruzione(short annoCostruzione) {
		this.annoCostruzione = annoCostruzione;
	}


	public AriaCondizionata getAriaCondizionata() {
		return ariaCondizionata;
	}


	public void setAriaCondizionata(AriaCondizionata ariaCondizionata) {
		this.ariaCondizionata = ariaCondizionata;
	}


	public String getArredamento() {
		return arredamento;
	}


	public void setArredamento(String arredamento) {
		this.arredamento = arredamento;
	}


	public byte getAscensore() {
		return ascensore;
	}


	public void setAscensore(byte ascensore) {
		this.ascensore = ascensore;
	}


	public String getBagniMin() {
		return bagniMin;
	}


	public void setBagniMin(String bagniMin) {
		this.bagniMin = bagniMin;
	}


	public byte getBalcone() {
		return balcone;
	}


	public void setBalcone(byte balcone) {
		this.balcone = balcone;
	}


	public ClasseEnergetica getClasseEnergetica() {
		return classeEnergetica;
	}


	public void setClasseEnergetica(ClasseEnergetica classeEnergetica) {
		this.classeEnergetica = classeEnergetica;
	}


	public String getComune() {
		return comune;
	}


	public void setComune(String comune) {
		this.comune = comune;
	}


	public Condizione getCondizione() {
		return condizione;
	}


	public void setCondizione(Condizione condizione) {
		this.condizione = condizione;
	}


	public String getFrazione() {
		return frazione;
	}


	public void setFrazione(String frazione) {
		this.frazione = frazione;
	}


	public String getGiardino() {
		return giardino;
	}


	public void setGiardino(String giardino) {
		this.giardino = giardino;
	}


	public int getLocaliMax() {
		return localiMax;
	}


	public void setLocaliMax(int localiMax) {
		this.localiMax = localiMax;
	}


	public int getLocaliMin() {
		return localiMin;
	}


	public void setLocaliMin(int localiMin) {
		this.localiMin = localiMin;
	}


	public int getMqMax() {
		return mqMax;
	}


	public void setMqMax(int mqMax) {
		this.mqMax = mqMax;
	}


	public int getMqMin() {
		return mqMin;
	}


	public void setMqMin(int mqMin) {
		this.mqMin = mqMin;
	}


	public String getPiano() {
		return piano;
	}


	public void setPiano(String piano) {
		this.piano = piano;
	}


	public byte getPiscina() {
		return piscina;
	}


	public void setPiscina(byte piscina) {
		this.piscina = piscina;
	}


	public byte getPortineria() {
		return portineria;
	}


	public void setPortineria(byte portineria) {
		this.portineria = portineria;
	}


	public String getPostiAuto() {
		return postiAuto;
	}


	public void setPostiAuto(String postiAuto) {
		this.postiAuto = postiAuto;
	}


	public int getPrezzoMax() {
		return prezzoMax;
	}


	public void setPrezzoMax(int prezzoMax) {
		this.prezzoMax = prezzoMax;
	}


	public int getPrezzoMin() {
		return prezzoMin;
	}


	public void setPrezzoMin(int prezzoMin) {
		this.prezzoMin = prezzoMin;
	}


	public double getRaggio() {
		return raggio;
	}


	public void setRaggio(double raggio) {
		this.raggio = raggio;
	}


	public Riscaldamento getRiscaldamento() {
		return riscaldamento;
	}


	public void setRiscaldamento(Riscaldamento riscaldamento) {
		this.riscaldamento = riscaldamento;
	}


	public StatoRogito getStatoRogito() {
		return statoRogito;
	}


	public void setStatoRogito(StatoRogito statoRogito) {
		this.statoRogito = statoRogito;
	}


	public byte getTerrazzo() {
		return terrazzo;
	}


	public void setTerrazzo(byte terrazzo) {
		this.terrazzo = terrazzo;
	}


	public TipoAnnuncio getTipoAnnuncio() {
		return tipoAnnuncio;
	}


	public void setTipoAnnuncio(TipoAnnuncio tipoAnnuncio) {
		this.tipoAnnuncio = tipoAnnuncio;
	}


	public TipoImmobile getTipoImmobile() {
		return tipoImmobile;
	}


	public void setTipoImmobile(TipoImmobile tipoImmobile) {
		this.tipoImmobile = tipoImmobile;
	}


	public TipoMappa getTipoMappa() {
		return tipoMappa;
	}


	public void setTipoMappa(TipoMappa tipoMappa) {
		this.tipoMappa = tipoMappa;
	}


	public TipoRicerca getTipoRicerca() {
		return tipoRicerca;
	}


	public void setTipoRicerca(TipoRicerca tipoRicerca) {
		this.tipoRicerca = tipoRicerca;
	}


	public Timestamp getUltimoTimestamp() {
		return ultimoTimestamp;
	}


	public void setUltimoTimestamp(Timestamp ultimoTimestamp) {
		this.ultimoTimestamp = ultimoTimestamp;
	}


	public byte getVirtualTour() {
		return virtualTour;
	}


	public void setVirtualTour(byte virtualTour) {
		this.virtualTour = virtualTour;
	}


	public byte getVisitaGuidata() {
		return visitaGuidata;
	}


	public void setVisitaGuidata(byte visitaGuidata) {
		this.visitaGuidata = visitaGuidata;
	}


	public List<Punto> getPuntos() {
		return puntos;
	}


	public void setPuntos(List<Punto> puntos) {
		this.puntos = puntos;
	}


	public List<Utente> getSalvatoDa() {
		return salvatoDa;
	}


	public void setSalvatoDa(List<Utente> salvatoDa) {
		this.salvatoDa = salvatoDa;
	}

}