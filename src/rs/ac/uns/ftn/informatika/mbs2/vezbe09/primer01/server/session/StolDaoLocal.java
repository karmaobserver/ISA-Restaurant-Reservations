package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session;

import java.util.List;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Restoran;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Stol;

public interface StolDaoLocal extends GenericDaoLocal<Stol, Integer> {
	
	public List<Stol> nadjiStoloveZaOdredjenRestoran(Integer idRestorana);

}
