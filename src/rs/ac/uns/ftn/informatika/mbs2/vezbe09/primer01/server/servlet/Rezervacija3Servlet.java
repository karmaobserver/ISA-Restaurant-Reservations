package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.servlet;

import java.io.IOException;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Gost;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Restoran;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Rezervacija;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.RezervacijaDaoLocal;

//izvrsi krajnju rezervaciju
public class Rezervacija3Servlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -31757488152141047L;
	
	@EJB
	private RezervacijaDaoLocal rezervacijaDao;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Gost gostUSesiji = (Gost)req.getSession().getAttribute("gost"); 
		
		
		if(gostUSesiji==null){
			System.out.println("SESIJA je NULL SIS");
			 RequestDispatcher disp = req.getRequestDispatcher("login.jsp");
			 disp.forward(req, resp);
			 return;
		}
		req.getRequestDispatcher("rezervacija3.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Gost gostUSesiji = (Gost)req.getSession().getAttribute("gost"); 
		
		
		if(gostUSesiji==null){
			System.out.println("SESIJA je NULL SIS");
			 RequestDispatcher disp = req.getRequestDispatcher("login.jsp");
			 disp.forward(req, resp);
			 return;
		}
		Restoran restoran = (Restoran) req.getSession().getAttribute("restoranUSesijiRezervacije");
		Date datum = (Date) req.getSession().getAttribute("formatiranDatumUSesiji");
		Integer trajanje = (Integer) req.getSession().getAttribute("trajanjeUSesiji");
	
		Rezervacija rezervacija = new Rezervacija();
		
		rezervacija.setRestoran(restoran);
		rezervacija.setDatum(datum);
		rezervacija.setGost(gostUSesiji);
		rezervacija.setTrajanje(trajanje);
		
		rezervacijaDao.persist(rezervacija);
		
		req.setAttribute("porukaRezervacije", "Uspesno ste izvrsili rezervaciju");
		req.getRequestDispatcher("rezervisano.jsp").forward(req, resp);
		
	}

	
}
