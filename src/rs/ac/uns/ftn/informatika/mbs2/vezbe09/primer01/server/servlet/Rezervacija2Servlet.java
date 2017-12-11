package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Gost;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Restoran;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Stol;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.GostDaoLocal;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.StolDaoLocal;

public class Rezervacija2Servlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8787568156927852740L;
	@EJB
	private StolDaoLocal stolDao;
	@EJB
	private GostDaoLocal gostDao;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Gost gostUSesiji = (Gost)req.getSession().getAttribute("gost"); 
		
		
		if(gostUSesiji==null){
			System.out.println("SESIJA je NULL SIS");
			 RequestDispatcher disp = req.getRequestDispatcher("login.jsp");
			 disp.forward(req, resp);
			 return;
		}
		
		req.getRequestDispatcher("rezervacija2.jsp").forward(req, resp);
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
		
		Restoran restoranUSesiji = (Restoran) req.getSession().getAttribute("restoranUSesijiRezervacije");
		
		Integer iteracija = new Integer(req.getParameter("iteracija"));
		System.out.println("ITERACIJE: " + iteracija);
		

		
		for(int i=1; i<iteracija+1; i++) {
			
			
			String iString = Integer.toString(i);
			
			
			
				System.out.println("iString je: " + iString);
				System.out.println("iStringGET PARAM je: " + req.getParameter(iString));
				
				
				if (req.getParameter(iString) != null) {
					System.out.println("NIJE null");
				
					Integer id_stola = new Integer(req.getParameter(iString));
					System.out.println("ID STOLA: " + id_stola);
					 Stol stolUKojiSeUpisuje = stolDao.findById(id_stola);
					 
					 stolUKojiSeUpisuje.setZauzet(true);
					 
					 stolDao.merge(stolUKojiSeUpisuje);
					
				} else {
					System.out.println("NULL JE");
					
				}
			
			 
			
		}
		
		req.setAttribute("prijateljiGost", gostDao.ucitajPrijatelje(gostUSesiji));
		req.getRequestDispatcher("rezervacija3.jsp").forward(req, resp);
	}
	
	
}
