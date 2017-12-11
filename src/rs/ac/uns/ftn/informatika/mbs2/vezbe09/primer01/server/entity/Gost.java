package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="gost")
//@NamedQuery(name="logovanjeGost", query="SELECT a FROM Gost a WHERE a.mail like :mail AND a.lozinka like :lozinka")
@NamedQueries({
    @NamedQuery(name="logovanjeGost",
                query="SELECT a FROM Gost a WHERE a.mail like :mail AND a.lozinka like :lozinka"),
    @NamedQuery(name="mailProvera",
                query="SELECT a, g, s FROM MenadzerRestorana a, Gost g, MenadzerSistema s WHERE a.mail like :mail OR g.mail like :mail OR s.mail like :mail"),
    @NamedQuery(name="nadjiPoImenuGosta",
    			query="SELECT g FROM Gost g WHERE g.ime like :ime OR g.prezime like :ime"),
}) 
public class Gost extends Korisnik {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6129220237320338968L;
	
	@Column(name="broj_poseta", unique=false, nullable=true)
	private Integer brojPoseta;
	
	@Column(name="lokacija_x", unique=false, nullable=true)
	private BigDecimal lokacijaX;
	
	@Column(name="lokacija_y", unique=false, nullable=true)
	private BigDecimal lokacijaY;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "prijatelji",
				joinColumns = @JoinColumn(name = "prijatelj1", referencedColumnName="id"),
				inverseJoinColumns = @JoinColumn(name = "prijatelj2", referencedColumnName="id"))
	private Set<Gost> prijatelji = new HashSet<Gost>();
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy="gost")
	private Set<Rezervacija> rezervacije = new HashSet<Rezervacija>();
	
	public void dodajPrijatelja(Gost gost) {
		prijatelji.add(gost);
	}

	public void izbrisiPrijatelja(Gost gost) {
		prijatelji.remove(gost);
	}
	
 
	public Gost() {
		super();
	}




	public Integer getBrojPoseta() {
		return brojPoseta;
	}

	public void setBrojPoseta(Integer brojPoseta) {
		this.brojPoseta = brojPoseta;
	}

	public BigDecimal getLokacijaX() {
		return lokacijaX;
	}

	public void setLokacijaX(BigDecimal lokacijaX) {
		this.lokacijaX = lokacijaX;
	}

	public BigDecimal getLokacijaY() {
		return lokacijaY;
	}

	public void setLokacijaY(BigDecimal lokacijaY) {
		this.lokacijaY = lokacijaY;
	}

	public Set<Gost> getPrijatelji() {
		return prijatelji;
	}

	public void setPrijatelji(Set<Gost> prijatelji) {
		this.prijatelji = prijatelji;
	}

	public Set<Rezervacija> getRezervacije() {
		return rezervacije;
	}

	public void setRezervacije(Set<Rezervacija> rezervacije) {
		this.rezervacije = rezervacije;
	}

	


	
	
	
	
	
	
}
