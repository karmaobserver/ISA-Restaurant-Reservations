package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.Query;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Gost;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Rezervacija;

@Stateless
@Local(RezervacijaDaoLocal.class)
public class RezervacijaDaoBean extends GenericDaoBean<Rezervacija, Integer> implements RezervacijaDaoLocal{

	@Override
	public List<Rezervacija> nadjiRezervacijeZaGosta(Gost gost) {
		Query q = em.createNamedQuery("nadjiRezervacijeZaGosta");
		q.setParameter("gost", gost);
		
		List rez = new ArrayList<Rezervacija>();
		 rez =   q.getResultList();
		 return rez;
	}

}
