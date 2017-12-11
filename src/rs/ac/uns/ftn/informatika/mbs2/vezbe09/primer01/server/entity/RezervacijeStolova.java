package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="rezervacije_stolova")
public class RezervacijeStolova implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2056472943226040012L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_rezervacije_stolova", unique=true, nullable=false)
	private Integer id_rezervacije_stolova;
	
	@ManyToOne
	@JoinColumn(name = "rezervacija", referencedColumnName = "id_rezervacija", nullable = false)
	private Rezervacija rezervacija;
	
	@ManyToOne
	@JoinColumn(name = "stol", referencedColumnName = "id_stol", nullable = false)
	private Stol stol;

	public RezervacijeStolova() {
		super();
	}

	public Integer getId_rezervacije_stolova() {
		return id_rezervacije_stolova;
	}

	public void setId_rezervacije_stolova(Integer id_rezervacije_stolova) {
		this.id_rezervacije_stolova = id_rezervacije_stolova;
	}

	public Rezervacija getRezervacija() {
		return rezervacija;
	}

	public void setRezervacija(Rezervacija rezervacija) {
		this.rezervacija = rezervacija;
	}

	public Stol getStol() {
		return stol;
	}

	public void setStol(Stol stol) {
		this.stol = stol;
	}	
	
	
}
