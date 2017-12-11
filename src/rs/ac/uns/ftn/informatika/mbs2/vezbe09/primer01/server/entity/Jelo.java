package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity;





import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="jelo")
@NamedQuery(name = "nadjiJelaZaRestoranID", query = "SELECT j FROM Jelo j WHERE j.restoran.id_restoran = :id")
public class Jelo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6789976576846701011L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_jela", unique=true, nullable=false)
	private Integer id_jela;
	
	@Column(name="naziv_jela", unique=false, nullable=false)
	private String nazivJela;
	
	@Column(name="opis_jela", unique=false, nullable=true)
	private String opisJela;
	
	@Column(name="cena_jela", unique=false, nullable=false)
	private Double cenaJela;
	
	@ManyToOne
	@JoinColumn(name="restoran", referencedColumnName="id_restoran")
	private Restoran restoran;
	
	

	public Jelo() {
		super();
	}

	public Integer getId_jela() {
		return id_jela;
	}

	public void setId_jela(Integer id_jela) {
		this.id_jela = id_jela;
	}

	public String getNazivJela() {
		return nazivJela;
	}

	public void setNazivJela(String nazivJela) {
		this.nazivJela = nazivJela;
	}

	public String getOpisJela() {
		return opisJela;
	}

	public void setOpisJela(String opisJela) {
		this.opisJela = opisJela;
	}





	public Double getCenaJela() {
		return cenaJela;
	}

	public void setCenaJela(Double cenaJela) {
		this.cenaJela = cenaJela;
	}

	public Restoran getRestoran() {
		return restoran;
	}

	public void setRestoran(Restoran restoran) {
		this.restoran = restoran;
	}

	@Override
	public String toString() {
		return "Jelo [id_jela=" + id_jela + ", nazivJela=" + nazivJela + ", opisJela=" + opisJela + ", cenaJela="
				+ cenaJela + ", restoran=" + restoran + "]";
	}
	
	
	
}
