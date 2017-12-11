package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session;



import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;

import javax.ejb.Stateless;
import javax.persistence.Query;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Gost;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Restoran;

@Stateless
@Local(GostDaoLocal.class)
public class GostDaoBean extends GenericDaoBean<Gost, Integer> implements GostDaoLocal{

	@Override
	public Gost logovanjeGost(String mail, String lozinka) {
		Query q = em.createNamedQuery("logovanjeGost");
		q.setParameter("mail", mail);
		q.setParameter("lozinka", lozinka);
		Gost rezultat = (Gost) q.getSingleResult();
		return rezultat;
	}

	
	@SuppressWarnings("unchecked")
	public boolean  mailPostoji(String mail) {
		Query q = em.createNamedQuery("mailProvera");
		q.setParameter("mail", mail);
		List<Gost> rez = new ArrayList<Gost>();
		 rez =  (List<Gost>) q.getResultList();
		if (rez.isEmpty()) {
			//System.out.println("Prazna");
			return false;
		} else {
			//System.out.println("neprazna");
			return true;
		}
	
	}


	@Override
	public Gost ucitajPrijatelje(Gost gost) {
		Gost rez = em.merge(gost);
		System.out.println("rez: " + rez);
		rez.getPrijatelji();
		System.out.println("rezNAKON: " + rez);
		return rez;
		
	}


	@Override
	public ArrayList<Gost> dodajPrijatelja(Gost koDodaje, Gost kogaDodaje) {
			kogaDodaje = em.merge(kogaDodaje);
	        kogaDodaje.getPrijatelji();
	        
	        koDodaje = em.merge(koDodaje);
	        koDodaje.getPrijatelji();
	       
	        System.out.println("KOGA DODAJE " + kogaDodaje);
	        System.out.println("KO   DODAJE: " + koDodaje);
	        kogaDodaje.dodajPrijatelja(koDodaje);
	        koDodaje.dodajPrijatelja(kogaDodaje);
	           
	        ArrayList<Gost> lista = new ArrayList<Gost>();
	        lista.add(koDodaje);
	        lista.add(kogaDodaje);
	        return lista;
	}



	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Gost> nadjiPoImenuGosta(String ime) {
		Query q = em.createNamedQuery("nadjiPoImenuGosta");
		q.setParameter("ime", ime);
		
		List rez = new ArrayList<Gost>();
		 rez =   q.getResultList();
		 return rez;
		
	}


	@Override
	public void izbrisiPrijatelja(Gost koBrise, Gost kogaBrise) {
		kogaBrise = em.merge(kogaBrise);
		kogaBrise.getPrijatelji();
        
		koBrise = em.merge(koBrise);
		koBrise.getPrijatelji();
       
        System.out.println("KOGA BRISE " + kogaBrise);
        System.out.println("KO   BRISE: " + koBrise);
        kogaBrise.izbrisiPrijatelja(koBrise);
        koBrise.izbrisiPrijatelja(kogaBrise);
           
       // ArrayList<Gost> lista = new ArrayList<Gost>();
       // lista.add(koDodaje);
       // lista.add(kogaDodaje);
        //return rez;
		
	}


	
}
	
	
	


	
	


