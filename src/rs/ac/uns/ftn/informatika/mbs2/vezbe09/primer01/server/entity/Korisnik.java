package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

//ova klasa nije entity (ne mapira se na tabelu u bazi) ali njeni propertiji
//ce biti nasledjeni u entity klasama - otuda je potrebna ova anotacija
@MappedSuperclass
public abstract class Korisnik implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7320599474766070789L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	protected Integer id;
	
	@Column(name="ime", unique=false, nullable=false)
	protected String ime;
	
	@Column(name="prezime", unique=false, nullable=false)
	protected String prezime;
	
	@Column(name="mail", unique=false, nullable=false)
	protected String mail;
	
	@Column(name="lozinka", unique=false, nullable=false)
	protected String lozinka;
	
	@Column(name="adresa", unique=false, nullable=false)
	protected String adresa;
	
	@Column(name="slika", unique=false, nullable=false)
	protected String slika;
	
	
	
	public Korisnik() {}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getIme() {
		return ime;
	}


	public void setIme(String ime) {
		this.ime = ime;
	}


	public String getPrezime() {
		return prezime;
	}


	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getLozinka() {
		return lozinka;
	}


	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}


	public String getAdresa() {
		return adresa;
	}


	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	
	

	public String getSlika() {
		return slika;
	}


	public void setSlika(String slika) {
		this.slika = slika;
	}


	@Override
	public String toString() {
		return "Korisnik [id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", mail=" + mail + ", lozinka="
				+ lozinka + ", adresa=" + adresa + ", slika=" + slika + "]";
	}


	
	
	
	
	
	
}
