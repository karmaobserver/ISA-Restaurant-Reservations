package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.Query;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Gost;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.MenadzerRestorana;

@Stateless
@Local(MenadzerRestoranaDaoLocal.class)
public class MenadzerRestoranaDaoBean extends GenericDaoBean<MenadzerRestorana, Integer> implements MenadzerRestoranaDaoLocal{

	@Override
	public MenadzerRestorana logovanjeMenadzerRestorana(String mail, String lozinka) {
		Query q = em.createNamedQuery("logovanjeMenadzerRestorana");
		q.setParameter("mail", mail);
		q.setParameter("lozinka", lozinka);
		MenadzerRestorana rezultat = (MenadzerRestorana) q.getSingleResult();
		return rezultat;
	}

	@SuppressWarnings("unchecked")
	public boolean  mailPostoji(String mail) {
		Query q = em.createNamedQuery("mailProveraMenadzera");
		q.setParameter("mail", mail);
		List<MenadzerRestorana> rez = new ArrayList<MenadzerRestorana>();
		 rez =  (List<MenadzerRestorana>) q.getResultList();
		if (rez.isEmpty()) {
			System.out.println("Prazna");
			return false;
		} else {
			System.out.println("neprazna");
			return true;
		}
	
	}

}
