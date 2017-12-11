package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity;

import java.io.Serializable;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="rezervacija")
@NamedQuery(name = "nadjiRezervacijeZaGosta", query = "SELECT r FROM Rezervacija r WHERE r.gost = :gost")
public class Rezervacija implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5304069817152024848L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_rezervacija", unique=true, nullable=false)
	private Integer id_rezervacija;
	
	@Column(name="datum", unique=false, nullable=false)
	private Date datum;
	
	@Column(name="trajanje", unique=false, nullable=false)
	private Integer trajanje;
	
	@ManyToOne
	@JoinColumn(name="gost", referencedColumnName="id")
	private Gost gost;
	
	@ManyToOne
	@JoinColumn(name="restoran", referencedColumnName="id_restoran")
	private Restoran restoran;

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "rezervacija")
	private Set<RezervacijeStolova> stolovi = new HashSet<RezervacijeStolova>();
	
	public void dodajStolove(RezervacijeStolova rs) {
		stolovi.add(rs);
	}

	public Rezervacija() {
		super();
	}

	public Integer getId_rezervacija() {
		return id_rezervacija;
	}

	public void setId_rezervacija(Integer id_rezervacija) {
		this.id_rezervacija = id_rezervacija;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public Integer getTrajanje() {
		return trajanje;
	}

	public void setTrajanje(Integer trajanje) {
		this.trajanje = trajanje;
	}

	
	


	public Gost getGost() {
		return gost;
	}

	public void setGost(Gost gost) {
		this.gost = gost;
	}

	public Restoran getRestoran() {
		return restoran;
	}

	public void setRestoran(Restoran restoran) {
		this.restoran = restoran;
	}

	public Set<RezervacijeStolova> getStolovi() {
		return stolovi;
	}

	public void setStolovi(Set<RezervacijeStolova> stolovi) {
		this.stolovi = stolovi;
	}
	
	
	
	
	
}
