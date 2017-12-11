package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session;

import java.util.List;


import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Restoran;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Stol;

public interface RestoranDaoLocal extends GenericDaoLocal<Restoran, Integer> {
	
	public Restoran nadjiRestoranZaId(Integer id);
	
	
}
