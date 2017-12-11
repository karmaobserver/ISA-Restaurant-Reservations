package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity;

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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="stol")
@NamedQuery(name = "nadjiStoloveZaOdredjenRestoran", query = "SELECT s FROM Stol s WHERE s.restoran.id_restoran like :idRestorana")
public class Stol implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8049689760581775383L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_stol", unique=true, nullable=false)
	private Integer id_stol;
	
	@Column(name="zauzet", unique=false, nullable=false)
	private Boolean zauzet;
	
	@Column(name="postoji", unique=false, nullable=false)
	private Boolean postoji;
	
	@ManyToOne
	@JoinColumn(name="restoran", referencedColumnName="id_restoran")
	private Restoran restoran;
	
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "rezervacija")
	private Set<RezervacijeStolova> rezervacije = new HashSet<RezervacijeStolova>();
	
	public void dodajRezervacije(RezervacijeStolova rs){
		rezervacije.add(rs);
	}

	public Stol() {
		super();
	}

	public Integer getId_stol() {
		return id_stol;
	}

	public void setId_stol(Integer id_stol) {
		this.id_stol = id_stol;
	}

	public Boolean getZauzet() {
		return zauzet;
	}

	public void setZauzet(Boolean zauzet) {
		this.zauzet = zauzet;
	}

	public Boolean getPostoji() {
		return postoji;
	}

	public void setPostoji(Boolean postoji) {
		this.postoji = postoji;
	}

	public Restoran getRestoran() {
		return restoran;
	}

	public void setRestoran(Restoran restoran) {
		this.restoran = restoran;
	}
	
	
	public Set<RezervacijeStolova> getRezervacije() {
		return rezervacije;
	}

	public void setRezervacije(Set<RezervacijeStolova> rezervacije) {
		this.rezervacije = rezervacije;
	}

	@Override
	public String toString() {
		return "Stol [id_stol=" + id_stol + ", zauzet=" + zauzet + ", postoji=" + postoji + ", restoran=" + restoran
				+ "]";
	}
	
	
	
}
