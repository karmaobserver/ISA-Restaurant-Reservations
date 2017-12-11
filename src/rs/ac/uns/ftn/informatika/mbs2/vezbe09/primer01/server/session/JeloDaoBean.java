package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.Query;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Jelo;



@Stateless
@Local(JeloDaoLocal.class)
public class JeloDaoBean extends GenericDaoBean<Jelo, Integer> implements JeloDaoLocal{

	@Override
	public List<Jelo> nadjiJelaZaRestoranID(Integer id) {
		Query q = em.createNamedQuery("nadjiJelaZaRestoranID");
		q.setParameter("id", id);
		@SuppressWarnings("unchecked")
		List<Jelo> rez = (List<Jelo>) q.getResultList();
		return rez;
	}

}
