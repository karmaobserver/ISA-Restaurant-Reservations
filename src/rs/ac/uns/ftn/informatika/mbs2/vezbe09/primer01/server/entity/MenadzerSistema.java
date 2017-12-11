package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="menadzer_sistema")
@NamedQueries({
    @NamedQuery(name="logovanjeMenadzerSistema",
                query="SELECT a FROM MenadzerSistema a WHERE a.mail like :mail AND a.lozinka like :lozinka"),
    @NamedQuery(name="mailProveraSistema",
                query="SELECT a, g, s FROM MenadzerRestorana a, Gost g, MenadzerSistema s WHERE a.mail like :mail OR g.mail like :mail OR s.mail like :mail"),
}) 
public class MenadzerSistema extends Korisnik {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2492565920307741142L;

	public MenadzerSistema() {}
	
	
}
