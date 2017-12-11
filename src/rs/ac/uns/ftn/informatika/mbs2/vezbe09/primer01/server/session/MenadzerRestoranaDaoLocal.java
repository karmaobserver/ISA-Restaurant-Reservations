package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session;


import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.MenadzerRestorana;

public interface MenadzerRestoranaDaoLocal extends GenericDaoLocal<MenadzerRestorana, Integer> {
	
	public MenadzerRestorana logovanjeMenadzerRestorana(String mail, String lozinka);
	
	public boolean mailPostoji(String mail);
}
