package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session;

import java.util.ArrayList;
import java.util.List;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Gost;

public interface GostDaoLocal extends GenericDaoLocal<Gost, Integer>{
	
	public Gost logovanjeGost(String mail, String lozinka);
	
	public boolean mailPostoji(String mail);
	
	public Gost ucitajPrijatelje(Gost gost);
	
	public ArrayList<Gost> dodajPrijatelja(Gost koDodaje, Gost kogaDodaje);
	
	public List<Gost> nadjiPoImenuGosta(String ime);
	
	public void izbrisiPrijatelja(Gost koBrise, Gost kogaBrise);
	
}
