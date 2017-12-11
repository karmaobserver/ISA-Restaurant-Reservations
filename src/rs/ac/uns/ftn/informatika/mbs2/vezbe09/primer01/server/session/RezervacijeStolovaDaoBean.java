package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session;

import javax.ejb.Local;
import javax.ejb.Stateless;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Restoran;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Rezervacija;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.RezervacijeStolova;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Stol;

@Stateless
@Local(RezervacijeStolovaDaoLocal.class)
public class RezervacijeStolovaDaoBean extends GenericDaoBean<RezervacijeStolova, Integer> implements RezervacijeStolovaDaoLocal{

	@Override
	public Restoran kojaRezervacijaKolkoStolova(Rezervacija rezervacija, Stol stol) {
		// TODO Auto-generated method stub
		return null;
	}

}
