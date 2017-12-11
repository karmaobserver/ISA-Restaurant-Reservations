package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity;

import static javax.persistence.CascadeType.ALL;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="restoran")
@NamedQuery(name = "nadjiRestoranZaId", query = "SELECT r FROM Restoran r WHERE r.id_restoran = :id")
public class Restoran implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4503346469312871801L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_restoran", unique=true, nullable=false)
	private Integer id_restoran;
	
	@Column(name="naziv_restorana", unique=false, nullable=false)
	private String nazivRestorana;
	
	@Column(name="opis_restorana", unique=false, nullable=true)
	private String opisRestorana;
	
	@Column(name="kolona", unique=false, nullable=true)
	private Integer kolona;
	
	@Column(name="redova", unique=false, nullable=true)
	private Integer redova;
	
	
	@OneToMany(cascade={ALL}, fetch =FetchType.LAZY, mappedBy = "restoran")
	private Set<MenadzerRestorana> menadzerRestorana = new HashSet<MenadzerRestorana>();
	
	@OneToMany(cascade=ALL, fetch=FetchType.LAZY, mappedBy="restoran")
	private Set<Jelo> jelovnik = new HashSet<Jelo>();
	
	
	@OneToMany(cascade=ALL, fetch=FetchType.LAZY, mappedBy="restoran")
	private Set<Stol> stolovi = new HashSet<Stol>();
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy="restoran")
	private Set<Rezervacija> rezervacije = new HashSet<Rezervacija>();
	
	public Restoran() {}
	
	public Integer getId_restoran() {
		return id_restoran;
	}

	public void setId_restoran(Integer id_restoran) {
		this.id_restoran = id_restoran;
	}

/*	public Set<MenadzerRestorana> getMenadzerRestorana() {
		return menadzerRestorana;
	}

	public void setMenadzerRestorana(Set<MenadzerRestorana> menadzerRestorana) {
		this.menadzerRestorana = menadzerRestorana;
	}*/
	
	

	public String getNazivRestorana() {
		return nazivRestorana;
	}

	public Set<MenadzerRestorana> getMenadzerRestorana() {
		return menadzerRestorana;
	}

	public void setMenadzerRestorana(Set<MenadzerRestorana> menadzerRestorana) {
		this.menadzerRestorana = menadzerRestorana;
	}

	public void setNazivRestorana(String nazivRestorana) {
		this.nazivRestorana = nazivRestorana;
	}

	public String getOpisRestorana() {
		return opisRestorana;
	}

	public void setOpisRestorana(String opisRestorana) {
		this.opisRestorana = opisRestorana;
	}

	public Set<Jelo> getJelovnik() {
		return jelovnik;
	}

	public void setJelovnik(Set<Jelo> jelovnik) {
		this.jelovnik = jelovnik;
	}

	public Set<Stol> getStolovi() {
		return stolovi;
	}

	public void setStolovi(Set<Stol> stolovi) {
		this.stolovi = stolovi;
	}

	public Integer getKolona() {
		return kolona;
	}

	public void setKolona(Integer kolona) {
		this.kolona = kolona;
	}

	public Integer getRedova() {
		return redova;
	}

	public void setRedova(Integer redova) {
		this.redova = redova;
	}

	public Set<Rezervacija> getRezervacije() {
		return rezervacije;
	}

	public void setRezervacije(Set<Rezervacija> rezervacije) {
		this.rezervacije = rezervacije;
	}
	
	
	
	
	
	

}
