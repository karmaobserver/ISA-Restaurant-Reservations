package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Restoran;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Rezervacija;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.RezervacijeStolova;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Stol;

public interface RezervacijeStolovaDaoLocal extends GenericDaoLocal<RezervacijeStolova, Integer> {
	
	public Restoran kojaRezervacijaKolkoStolova(Rezervacija rezervacija, Stol stol);
	
}
