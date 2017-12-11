package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session;



import java.util.List;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Jelo;



public interface JeloDaoLocal extends GenericDaoLocal<Jelo, Integer> {
	
	public List<Jelo> nadjiJelaZaRestoranID(Integer id);
}
