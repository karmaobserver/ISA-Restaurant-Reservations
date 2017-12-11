package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;

import javax.ejb.Stateless;
import javax.persistence.Query;


import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Stol;

@Stateless
@Local(StolDaoLocal.class)
public class StolDaoBean extends GenericDaoBean<Stol, Integer>  implements StolDaoLocal {

	@SuppressWarnings("unchecked")
	@Override
	public List<Stol> nadjiStoloveZaOdredjenRestoran(Integer idRestorana) {
		Query q = em.createNamedQuery("nadjiStoloveZaOdredjenRestoran");
		q.setParameter("idRestorana", idRestorana);
		List<Stol> rez = new ArrayList<Stol>();
		 rez =  q.getResultList();
		return rez;
	}

}
