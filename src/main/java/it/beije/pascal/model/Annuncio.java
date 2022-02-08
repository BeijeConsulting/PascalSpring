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
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import it.beije.pascal.model.enums.AriaCondizionata;
import it.beije.pascal.model.enums.ClasseEnergetica;
import it.beije.pascal.model.enums.Condizione;
import it.beije.pascal.model.enums.Giardino;
import it.beije.pascal.model.enums.Riscaldamento;
import it.beije.pascal.model.enums.TipoAnnuncio;
import it.beije.pascal.model.enums.TipoImmobile;


/**
 * The persistent class for the annuncio database table.
 * 
 */
@Entity
@NamedQuery(name="Annuncio.findAll", query="SELECT a FROM Annuncio a")
@Table(name = "annuncio")
public class Annuncio  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToMany(mappedBy = "annunciSalvati")
	private List<User> salvatoDa;

//	@Column(name="anno_costruzione")
//	private Integer annoCostruzione;

	@Enumerated(EnumType.STRING)
	@Column(name="aria_condizionata")
	private AriaCondizionata ariaCondizionata;

	private String arredamento;

	private Boolean ascensore;

	private Integer bagni;

	private Boolean balcone;

	@Enumerated(EnumType.STRING)
	@Column(name="classe_energetica")
	private ClasseEnergetica classeEnergetica;

	@Enumerated(EnumType.STRING)
	private Condizione condizione;

	@Column(name="create_timestamp")
	private Timestamp createTimestamp;

	@Lob
	@Column(name="descrizione_lunga")
	private String descrizioneLunga;

	@Enumerated(EnumType.STRING)
	private Giardino giardino;

	private Integer locali;

	private Integer mq;

	private Integer piano;

	private Boolean piscina;

	private Boolean portineria;

	@Column(name="posti_auto")
	private Integer postiAuto;

	private Integer prezzo;

	@Enumerated(EnumType.STRING)
	private Riscaldamento riscaldamento;

	@Column(name="stato_rogito")
	private String statoRogito;

	private Boolean terrazzo;

	@Enumerated(EnumType.STRING)
	@Column(name="tipo_annuncio")
	private TipoAnnuncio tipoAnnuncio;

	@Enumerated(EnumType.STRING)
	@Column(name="tipo_immobile")
	private TipoImmobile tipoImmobile;

	@Column(name="tot_piani")
	private Integer totPiani;

	@Column(name="virtual_tour")
	private Boolean virtualTour;

	@Column(name="visita_guidata")
	private Boolean visitaGuidata;

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
	private User utente;

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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<User> getSalvatoDa() {
		return salvatoDa;
	}

	public void setSalvatoDa(List<User> salvatoDa) {
		this.salvatoDa = salvatoDa;
	}

//	public Integer getAnnoCostruzione() {
//		return annoCostruzione;
//	}
//
//	public void setAnnoCostruzione(Integer annoCostruzione) {
//		this.annoCostruzione = annoCostruzione;
//	}

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

	public Boolean getAscensore() {
		return ascensore;
	}

	public void setAscensore(Boolean ascensore) {
		this.ascensore = ascensore;
	}

	public Integer getBagni() {
		return bagni;
	}

	public void setBagni(Integer bagni) {
		this.bagni = bagni;
	}

	public Boolean getBalcone() {
		return balcone;
	}

	public void setBalcone(Boolean balcone) {
		this.balcone = balcone;
	}

	public ClasseEnergetica getClasseEnergetica() {
		return classeEnergetica;
	}

	public void setClasseEnergetica(ClasseEnergetica classeEnergetica) {
		this.classeEnergetica = classeEnergetica;
	}

	public Condizione getCondizione() {
		return condizione;
	}

	public void setCondizione(Condizione condizione) {
		this.condizione = condizione;
	}

	public Timestamp getCreateTimestamp() {
		return createTimestamp;
	}

	public void setCreateTimestamp(Timestamp createTimestamp) {
		this.createTimestamp = createTimestamp;
	}

	public String getDescrizioneLunga() {
		return descrizioneLunga;
	}

	public void setDescrizioneLunga(String descrizioneLunga) {
		this.descrizioneLunga = descrizioneLunga;
	}

	public Giardino getGiardino() {
		return giardino;
	}

	public void setGiardino(Giardino giardino) {
		this.giardino = giardino;
	}

	public Integer getLocali() {
		return locali;
	}

	public void setLocali(Integer locali) {
		this.locali = locali;
	}

	public Integer getMq() {
		return mq;
	}

	public void setMq(Integer mq) {
		this.mq = mq;
	}

	public Integer getPiano() {
		return piano;
	}

	public void setPiano(Integer piano) {
		this.piano = piano;
	}

	public Boolean getPiscina() {
		return piscina;
	}

	public void setPiscina(Boolean piscina) {
		this.piscina = piscina;
	}

	public Boolean getPortineria() {
		return portineria;
	}

	public void setPortineria(Boolean portineria) {
		this.portineria = portineria;
	}

	public Integer getPostiAuto() {
		return postiAuto;
	}

	public void setPostiAuto(Integer postiAuto) {
		this.postiAuto = postiAuto;
	}

	public Integer getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Integer prezzo) {
		this.prezzo = prezzo;
	}

	public Riscaldamento getRiscaldamento() {
		return riscaldamento;
	}

	public void setRiscaldamento(Riscaldamento riscaldamento) {
		this.riscaldamento = riscaldamento;
	}

	public String getStatoRogito() {
		return statoRogito;
	}

	public void setStatoRogito(String statoRogito) {
		this.statoRogito = statoRogito;
	}

	public Boolean getTerrazzo() {
		return terrazzo;
	}

	public void setTerrazzo(Boolean terrazzo) {
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

	public Integer getTotPiani() {
		return totPiani;
	}

	public void setTotPiani(Integer totPiani) {
		this.totPiani = totPiani;
	}

	public Boolean getVirtualTour() {
		return virtualTour;
	}

	public void setVirtualTour(Boolean virtualTour) {
		this.virtualTour = virtualTour;
	}

	public Boolean getVisitaGuidata() {
		return visitaGuidata;
	}

	public void setVisitaGuidata(Boolean visitaGuidata) {
		this.visitaGuidata = visitaGuidata;
	}

	public Annuncio getAnnuncio() {
		return annuncio;
	}

	public void setAnnuncio(Annuncio annuncio) {
		this.annuncio = annuncio;
	}

	public List<Annuncio> getAnnunciInEdificio() {
		return annunciInEdificio;
	}

	public void setAnnunciInEdificio(List<Annuncio> annunciInEdificio) {
		this.annunciInEdificio = annunciInEdificio;
	}

	public User getUtente() {
		return utente;
	}

	public void setUtente(User utente) {
		this.utente = utente;
	}

	public Indirizzo getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(Indirizzo indirizzo) {
		this.indirizzo = indirizzo;
	}

	public Foto getFoto() {
		return foto;
	}

	public void setFoto(Foto foto) {
		this.foto = foto;
	}

	public List<Foto> getFotos() {
		return fotos;
	}

	public void setFotos(List<Foto> fotos) {
		this.fotos = fotos;
	}
}