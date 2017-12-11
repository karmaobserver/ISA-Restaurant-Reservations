package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="menadzer_restorana")
@NamedQueries({
    @NamedQuery(name="logovanjeMenadzerRestorana",
                query="SELECT a FROM MenadzerRestorana a WHERE a.mail like :mail AND a.lozinka like :lozinka"),
    @NamedQuery(name="mailProveraMenadzera",
                query="SELECT a, g, s FROM MenadzerRestorana a, Gost g, MenadzerSistema s WHERE a.mail like :mail OR g.mail like :mail OR s.mail like :mail"),
}) 
public class MenadzerRestorana extends Korisnik{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3804168297031756799L;
	
	@ManyToOne
	@JoinColumn(name="restoran", referencedColumnName="id_restoran", nullable=true)
	private Restoran restoran;

	public MenadzerRestorana() {
		
	}

	public Restoran getRestoran() {
		return restoran;
	}

	public void setRestoran(Restoran restoran) {
		this.restoran = restoran;
	}

	/*public Restoran getRestoranMenadzer() {
		return restoran;
	}

	public void setRestoranMenadzer(Restoran restoran) {
		this.restoran = restoran;
	}*/
	
	
	
	
	

}
