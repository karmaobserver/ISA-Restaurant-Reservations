package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.MenadzerSistema;

public interface MenadzerSistemaDaoLocal extends GenericDaoLocal<MenadzerSistema, Integer>{

	public MenadzerSistema logovanjeMenadzerSistema(String mail, String lozinka);
	
	public boolean mailPostoji(String mail);
}
