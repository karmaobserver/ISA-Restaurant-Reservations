package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.MenadzerSistema;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Restoran;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.RestoranDaoLocal;

public class DodavanjeRestoranaServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 569013134150932245L;
	
	@EJB
	private RestoranDaoLocal restDao;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MenadzerSistema menSisUSesiji = (MenadzerSistema)req.getSession().getAttribute("menadzerSistema"); 
		if(menSisUSesiji==null){
			System.out.println("SESIJA je NULL SIS");
			 RequestDispatcher disp = req.getRequestDispatcher("login.jsp");
			 disp.forward(req, resp);
			 return;
		}
		
		//req.setAttribute("restorani", restDao.findAll());
		RequestDispatcher disp = req.getRequestDispatcher("dodavanje_restorana.jsp");
		disp.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MenadzerSistema menSisUSesiji = (MenadzerSistema)req.getSession().getAttribute("menadzerSistema"); 
		if(menSisUSesiji==null){
			System.out.println("SESIJA je NULL SIS");
			 RequestDispatcher disp = req.getRequestDispatcher("login.jsp");
			 disp.forward(req, resp);
			 return;
		}
		
		String naziv = req.getParameter("nazivRestorana");
		String opis = req.getParameter("opisRestorana");
		
		if (naziv == null || "".equals(naziv) || opis == null || "".equals(opis)) {
			req.setAttribute("porukaPodaci", "Morate popuniti sve podatke");
			//System.out.println("nje isprav");
			//resp.sendRedirect(resp.encodeURL("./registracija.jsp"));
			RequestDispatcher disp = req.getRequestDispatcher("dodavanje_restorana.jsp");
			disp.forward(req, resp);
			return;
		} 
		
		Restoran rest = new Restoran();
		
		rest.setNazivRestorana(naziv);
		rest.setOpisRestorana(opis);
		
		restDao.persist(rest);
		
		req.setAttribute("porukaDodato", "Uspesno ste dodali restoran");
		
		RequestDispatcher disp = req.getRequestDispatcher("dodavanje_restorana.jsp");
		disp.forward(req, resp);
		
	}
}
