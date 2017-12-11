package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.Query;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Gost;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.MenadzerRestorana;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.MenadzerSistema;

@Stateless
@Local(MenadzerSistemaDaoLocal.class)
public class MenadzerSistemaDaoBean extends GenericDaoBean<MenadzerSistema, Integer> implements MenadzerSistemaDaoLocal{

	@Override
	public MenadzerSistema logovanjeMenadzerSistema(String mail, String lozinka) {
		Query q = em.createNamedQuery("logovanjeMenadzerSistema");
		q.setParameter("mail", mail);
		q.setParameter("lozinka", lozinka);
		MenadzerSistema rezultat = (MenadzerSistema) q.getSingleResult();
		return rezultat;
	}

	@SuppressWarnings("unchecked")
	public boolean  mailPostoji(String mail) {
		Query q = em.createNamedQuery("mailProveraSistema");
		q.setParameter("mail", mail);
		List<MenadzerSistema> rez = new ArrayList<MenadzerSistema>();
		 rez =  (List<MenadzerSistema>) q.getResultList();
		if (rez.isEmpty()) {
			//System.out.println("Prazna");
			return false;
		} else {
			//System.out.println("neprazna");
			return true;
		}
	
	}
	
	

}
