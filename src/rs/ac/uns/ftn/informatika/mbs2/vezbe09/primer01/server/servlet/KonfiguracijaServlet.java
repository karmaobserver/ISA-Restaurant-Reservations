package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.MenadzerRestorana;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Restoran;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Stol;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.StolDaoLocal;



public class KonfiguracijaServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2424786028373409377L;
	
	@EJB
	private StolDaoLocal stolDao;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MenadzerRestorana menRestUSesiji = (MenadzerRestorana)req.getSession().getAttribute("menadzerRestorana"); 
		//Restoran restUSesiji = (Restoran) req.getSession().getAttribute("restoranId");
		if(menRestUSesiji==null){
			System.out.println("SESIJA je NULL SIS");
			 RequestDispatcher disp = req.getRequestDispatcher("login.jsp");
			 disp.forward(req, resp);
			 return;
		}
		
		
		
		RequestDispatcher disp = req.getRequestDispatcher("konfiguracija_stolova.jsp");
		disp.forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MenadzerRestorana menRestUSesiji = (MenadzerRestorana)req.getSession().getAttribute("menadzerRestorana"); 
	
		if(menRestUSesiji==null){
			System.out.println("SESIJA je NULL SIS");
			 RequestDispatcher disp = req.getRequestDispatcher("login.jsp");
			 disp.forward(req, resp);
			 return;
		}
		
		
		Restoran restoranUSesiji = (Restoran) req.getSession().getAttribute("restoranUSesiji");
		
		Integer iteracija = new Integer(req.getParameter("iteracija"));
		System.out.println("ITERACIJE: " + iteracija);
		
		
		
		
		for(int i=1; i<iteracija+1; i++) {
			Boolean postoji = null; 
			String iString = Integer.toString(i);
				//System.out.println("STRING JE: " +iString);
				if ((req.getParameter(iString) != null) 	&& (!"".equals(req.getParameter(iString)))) {
					//System.out.println("ULAZI");
					 postoji = new Boolean(req.getParameter(iString));
				}
			
				 System.out.println("i je: " + iString);
					Stol stol = new Stol();
					
					if (postoji != null) {
						//System.out.println("#####ULAZI####");
						stol.setPostoji(true);
					}
					else 
						stol.setPostoji(false);
					
					
					 stol.setZauzet(false);
					 stol.setRestoran(restoranUSesiji);
					 
					// System.out.println("Postoji je: " + postoji);
					// System.out.println("DOlazi do persist");
					stolDao.persist(stol);
			 
			
		}
		
		//Restoran id_restorana = (Restoran) req.getSession().getAttribute("restoranUSesiji");
		
		
		req.setAttribute("porukaKonfiguracije", "Uspesno ste konfigurisali stolove za restoran");
		//req.getSession().setAttribute("Konfigurisano", true);
		//req.setAttribute("konfigurisano", true);
		req.getRequestDispatcher("home.jsp").forward(req, resp);
		
		
	}
}
		/*	ROBI ZA JEDEN CHECKBOX  @@@@@@@@@@@@@@@@@@@@@
		Boolean klimaUredjaj = null;
		
		if ((req.getParameter("klimaUredjaj") != null) 	&& (!"".equals(req.getParameter("klimaUredjaj")))) {
			System.out.println("ULAZI");
			klimaUredjaj = new Boolean(req.getParameter("klimaUredjaj"));
		}
		 System.out.println("Postoji je: " + klimaUredjaj);
		Stol stol = new Stol();
		
		if (klimaUredjaj != null) {
			System.out.println("#####ULAZI####");
			stol.setPostoji(true);
		}
		else 
			stol.setPostoji(false);
		
		
		 stol.setZauzet(false);
		System.out.println("Postoji2 je: " + klimaUredjaj);
		stolDao.persist(stol);
		
		req.getRequestDispatcher("raspored.jsp").forward(req, resp);
		
	}*/

