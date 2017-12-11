package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Gost;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Restoran;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.RestoranDaoLocal;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.StolDaoLocal;

public class RezervacijaServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4476146415290058931L;
	
	@EJB
	private RestoranDaoLocal restDao;
	@EJB
	private StolDaoLocal stolDao;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Gost gostUSesiji = (Gost)req.getSession().getAttribute("gost"); 
		
		
		if(gostUSesiji==null){
			System.out.println("SESIJA je NULL SIS");
			 RequestDispatcher disp = req.getRequestDispatcher("login.jsp");
			 disp.forward(req, resp);
			 return;
		}
		
		Integer id_restorana = new Integer(req.getParameter("id"));
		req.getSession().setAttribute("restoranUSesijiRezervacije", restDao.findById(id_restorana));
		
		/*ArrayList<Integer> trajanjeLista = new ArrayList<Integer>();
		for (int i=1; i<25; i++) {
			trajanjeLista.add(i);
		}
		req.setAttribute("trajanjeLista", trajanjeLista);*/
		req.getRequestDispatcher("rezervacija.jsp").forward(req, resp);
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
		String datum = req.getParameter("datum");
		Integer trajanje = new Integer(req.getParameter("trajanje"));
		
		System.out.println("DATUM: " + datum);
		System.out.println("TRAJANJE: " + trajanje);
		
		SimpleDateFormat formater = new SimpleDateFormat("dd.MM.yyyy HH:mm");
		Date formatiranDatum = null;
		try {
			formatiranDatum = formater.parse(datum);
			System.out.println("DATUMDORMATIRAN: " + formatiranDatum);
		} catch (ParseException e) {
			req.setAttribute("porukaParsiranja", "Doslo je do greske prilikom parsiranja datuma. Pokusajte ponovo.");
			req.getRequestDispatcher("rezervacija.jsp").forward(req, resp);
			return;
		}
		
		System.out.println("Izdojeni sati: " + formatiranDatum.getHours());
		int izdvojeniSati = formatiranDatum.getHours();
		if (izdvojeniSati+trajanje >= 24) {
			req.setAttribute("porukaTrajanja", "Restoran radi samo do ponoci");
			req.getRequestDispatcher("rezervacija.jsp").forward(req, resp);
			return;
		}
		
		req.getSession().setAttribute("formatiranDatumUSesiji", formatiranDatum);
		req.getSession().setAttribute("stringDatumUSesiji", datum);
		req.getSession().setAttribute("trajanjeUSesiji", trajanje);
		req.setAttribute("datum", formatiranDatum);
		
		Restoran restoranUSesiji = (Restoran) req.getSession().getAttribute("restoranUSesijiRezervacije");
		Integer id_restorana = restoranUSesiji.getId_restoran();
		req.setAttribute("stolovi", stolDao.nadjiStoloveZaOdredjenRestoran(id_restorana));
		req.getRequestDispatcher("rezervacija2.jsp").forward(req, resp);
		
		
	}

}
