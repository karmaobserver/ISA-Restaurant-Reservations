package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session;

import java.util.List;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Gost;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Rezervacija;

public interface RezervacijaDaoLocal extends GenericDaoLocal<Rezervacija, Integer> {
	
	public List<Rezervacija> nadjiRezervacijeZaGosta(Gost gost);

}
