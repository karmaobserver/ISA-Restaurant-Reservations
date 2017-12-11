package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Gost;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.MenadzerRestorana;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.MenadzerSistema;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Restoran;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.RestoranDaoLocal;

public class IzmenaRestoranaServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7896510463066037254L;
	
	@EJB
	private RestoranDaoLocal restDao;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MenadzerSistema menSisUSesiji = (MenadzerSistema)req.getSession().getAttribute("menadzerSistema"); 
		MenadzerRestorana menRestUSesiji = (MenadzerRestorana)req.getSession().getAttribute("menadzerRestorana");
		Gost gostUSesiji = (Gost)req.getSession().getAttribute("gost"); 
		
	
		
		
		Integer id_restorana = new Integer(req.getParameter("id"));
		System.out.println("ID RESTORANA "+ id_restorana);
		
		if(gostUSesiji != null) {
			req.getRequestDispatcher("izmena_restorana.jsp").forward(req, resp);
			
			
		} else if (menRestUSesiji != null) {
			req.setAttribute("restoranId", restDao.findById(id_restorana));
			
			req.getRequestDispatcher("izmena_restorana.jsp").forward(req, resp);
			
		} else if (menSisUSesiji != null) {
			
			
			
			req.getRequestDispatcher("izmena_restorana.jsp").forward(req, resp);
			
		} else {
			System.out.println("Sesija je NULL");
			 RequestDispatcher disp = req.getRequestDispatcher("login.jsp");
			 disp.forward(req, resp);
			 return;
			
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MenadzerSistema menSisUSesiji = (MenadzerSistema)req.getSession().getAttribute("menadzerSistema"); 
		MenadzerRestorana menRestUSesiji = (MenadzerRestorana)req.getSession().getAttribute("menadzerRestorana");
		Gost gostUSesiji = (Gost)req.getSession().getAttribute("gost"); 
		
	
		
		if(gostUSesiji != null) {

			req.getRequestDispatcher("izmena_restorana.jsp").forward(req, resp);
			
			
		} else if (menRestUSesiji != null) {
			
			String naziv = req.getParameter("nazivRestorana");
			String opis = req.getParameter("opisRestorana");
			
			
			if (naziv == null || "".equals(naziv) || opis == null || "".equals(opis)) {
				req.setAttribute("porukaPodaci", "Polje ne sme biti prazno");
				RequestDispatcher disp = req.getRequestDispatcher("izmena_restorana.jsp");
				disp.forward(req, resp);
				return;

			}
			
			Restoran restUSesiji = (Restoran) req.getSession().getAttribute("restoranId");
			
			//System.out.println("RESTORAN 2 U SESIJI: " + restUSesiji);
			
			
			restUSesiji.setNazivRestorana(naziv);
			restUSesiji.setOpisRestorana(opis);
			
			
			System.out.println("Dolazi do merge");
			restDao.merge(restUSesiji);
			
			req.setAttribute("porukaIzmene", "Uspesno ste izmenili podatke");
			
			req.getRequestDispatcher("izmena_restorana.jsp").forward(req, resp);
			
		} else if (menSisUSesiji != null) {
			
			
			
			
			req.getRequestDispatcher("izmena_restorana.jsp").forward(req, resp);
			
		} else {
			System.out.println("Sesija je NULL");
			 RequestDispatcher disp = req.getRequestDispatcher("login.jsp");
			 disp.forward(req, resp);
			 return;
			
		}
		
	}
}
