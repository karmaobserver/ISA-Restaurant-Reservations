package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session;



import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.Query;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Restoran;


@Stateless
@Local(RestoranDaoLocal.class)
public class RestoranDaoBean extends GenericDaoBean<Restoran, Integer> implements RestoranDaoLocal{

	@Override
	public Restoran nadjiRestoranZaId(Integer id) {
		Query q = em.createNamedQuery("nadjiRestoranZaId");
		q.setParameter("id", 1);
		Restoran rez =  (Restoran) q.getSingleResult();
		return rez;
	}

	
	
}
