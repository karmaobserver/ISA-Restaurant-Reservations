package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Gost;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Jelo;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.MenadzerRestorana;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.MenadzerSistema;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Restoran;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Rezervacija;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Stol;

@Stateless
@Remote(Init.class)
public class InitBean implements Init {

	@PersistenceContext(unitName = "Vezbe09")
	EntityManager em;
	
	public void init() {
		//Korisnik korisnik = new Korisnik("Sultan", "Obradovic", "admin", "admin");
		//em.persist(korisnik);
		
		Gost gost5 = new Gost();
		
		gost5.setAdresa("Strazilovska 95");
		gost5.setBrojPoseta(3);
		gost5.setIme("Dusan");
		gost5.setLozinka("gost5");
		gost5.setMail("gost5");
		gost5.setPrezime("Dusanovic");
		gost5.setSlika("zen.jpg");
		
		
		
		
		Gost gost = new Gost();
	
		gost.setAdresa("Jasabakova");
		gost.setBrojPoseta(2);
		gost.setIme("Pera");
		gost.setLozinka("gost");
		gost.setMail("gost");
		gost.setPrezime("Petrovic");
		gost.setSlika("zen.jpg");
		gost.dodajPrijatelja(gost5);
		em.persist(gost);
		
		
		Gost gost2 = new Gost();
		
		gost2.setAdresa("Bulevar");
		gost2.setBrojPoseta(3);
		gost2.setIme("Milan");
		gost2.setLozinka("gost2");
		gost2.setMail("gost2");
		gost2.setPrezime("Milivojevic");
		gost2.setSlika("zen.jpg");
		gost2.dodajPrijatelja(gost5);
		
		em.persist(gost2);
		
		Gost gost3 = new Gost();
		
		gost3.setAdresa("Cara Lazara");
		gost3.setBrojPoseta(3);
		gost3.setIme("Jela");
		gost3.setLozinka("gost3");
		gost3.setMail("gost3");
		gost3.setPrezime("Jelovic");
		gost3.setSlika("zen.jpg");
		gost3.dodajPrijatelja(gost5);
		
		em.persist(gost3);
		
		Gost gost4 = new Gost();
		
		gost4.setAdresa("Cara Dusana");
		gost4.setBrojPoseta(3);
		gost4.setIme("Milan");
		gost4.setLozinka("gost4");
		gost4.setMail("gost4");
		gost4.setPrezime("Tomasveic");
		gost4.setSlika("zen.jpg");
		gost4.dodajPrijatelja(gost5);
		
		em.persist(gost4);
		
		
		//Jos prijatelje da dodam obostrano
		gost5.dodajPrijatelja(gost);
		gost5.dodajPrijatelja(gost2);
		gost5.dodajPrijatelja(gost3);
		gost5.dodajPrijatelja(gost4);
		em.persist(gost5);
		
	
		
		
		
		
		
		Restoran restoran = new Restoran();
		restoran.setNazivRestorana("Dubaja");
		restoran.setOpisRestorana("Najbolja za jeftine pare pljenjdza u gradu");
		
		restoran.setKolona(2);
		restoran.setRedova(2);
		em.persist(restoran);
		

		Restoran restoran2 = new Restoran();
		restoran2.setNazivRestorana("Minuta");
		restoran2.setOpisRestorana("Minut za pire");
		em.persist(restoran2);
		
		Restoran restoran3 = new Restoran();
		restoran3.setNazivRestorana("KFC");
		restoran3.setOpisRestorana("Bataci u raznim sosevima");
		em.persist(restoran3);
		
		MenadzerRestorana menRestorana = new MenadzerRestorana();
		menRestorana.setAdresa("Aleksandra 98");
		menRestorana.setIme("Sole");
		menRestorana.setLozinka("rest");
		menRestorana.setMail("rest");
		menRestorana.setPrezime("Milojevic");
		menRestorana.setSlika("neut.jpg");
		menRestorana.setRestoran(restoran);
		em.persist(menRestorana);
		
		
		MenadzerRestorana menRestorana2 = new MenadzerRestorana();
		menRestorana2.setAdresa("Bulevar");
		menRestorana2.setIme("Kile");
		menRestorana2.setLozinka("rest2");
		menRestorana2.setMail("rest2");
		menRestorana2.setPrezime("Filovic");
		menRestorana2.setSlika("neut.jpg");
		menRestorana2.setRestoran(restoran2);	
		em.persist(menRestorana2);
		
		
		MenadzerSistema menSistema = new MenadzerSistema();	
		menSistema.setAdresa("jasabakova 46");
		menSistema.setIme("Mica");
		menSistema.setMail("sis");
		menSistema.setLozinka("sis");
		menSistema.setPrezime("Mickovic");
		menSistema.setSlika("mus.jpg");
		em.persist(menSistema);
		
		
		Jelo jelo1 = new Jelo();
		jelo1.setNazivJela("Pljeska");
		jelo1.setOpisJela("Bez soje");
		jelo1.setCenaJela(140.00);
		jelo1.setRestoran(restoran);	
		em.persist(jelo1);
		
		
		Jelo jelo2 = new Jelo();
		jelo2.setNazivJela("cevapi");
		jelo2.setOpisJela("kereci");
		jelo2.setCenaJela(80.50);
		jelo2.setRestoran(restoran);
		em.persist(jelo2);
		
		Jelo jelo3 = new Jelo();
		jelo3.setNazivJela("pire");
		jelo3.setOpisJela("minut za pire");
		jelo3.setCenaJela(40.00);
		jelo3.setRestoran(restoran2);
		em.persist(jelo3);
		
		Jelo jelo4 = new Jelo();
		jelo4.setNazivJela("pizza");
		jelo4.setOpisJela("pizza sa kulenom");
		jelo4.setCenaJela(160.00);
		jelo4.setRestoran(restoran2);
		em.persist(jelo4);
		
		Jelo jelo5 = new Jelo();
		jelo5.setNazivJela("batak");
		jelo5.setOpisJela("Batak u soja sosu");
		jelo5.setCenaJela(190.00);
		jelo5.setRestoran(restoran3);
		em.persist(jelo5);
		
		Jelo jelo6 = new Jelo();
		jelo6.setNazivJela("BatakSunka");
		jelo6.setOpisJela("Batak mesan sa sunkom");
		jelo6.setCenaJela(280.00);
		jelo6.setRestoran(restoran3);
		em.persist(jelo6);
		
		Stol stol1 = new Stol();
		stol1.setPostoji(true);
		stol1.setZauzet(false);
		stol1.setRestoran(restoran);
		em.persist(stol1);
		
		Stol stol2 = new Stol();
		stol2.setPostoji(true);
		stol2.setZauzet(false);
		stol2.setRestoran(restoran);
		em.persist(stol2);
		
		Stol stol3 = new Stol();
		stol3.setPostoji(false);
		stol3.setZauzet(false);
		stol3.setRestoran(restoran);
		em.persist(stol3);

		Stol stol4 = new Stol();
		stol4.setPostoji(true);
		stol4.setZauzet(false);
		stol4.setRestoran(restoran);
		em.persist(stol4);
		
		
		
		
	}
}
