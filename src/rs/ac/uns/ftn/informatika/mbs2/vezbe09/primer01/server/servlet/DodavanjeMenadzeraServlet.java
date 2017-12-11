package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.MenadzerRestorana;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.MenadzerSistema;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.MenadzerRestoranaDaoLocal;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.RestoranDaoLocal;

public class DodavanjeMenadzeraServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7979383337758397430L;
	
	@EJB
	private MenadzerRestoranaDaoLocal menRestDao;
	
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
		
		req.setAttribute("restorani", restDao.findAll());
		RequestDispatcher disp = req.getRequestDispatcher("dodavanje_menadzera.jsp");
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
		
		String ime = req.getParameter("imeMenadzera");
		String prezime = req.getParameter("prezimeMenadzera");
		String mail = req.getParameter("mailMenadzera");
		String lozinka = req.getParameter("lozinkaMenadzera");
		String adresa = req.getParameter("adresaMenadzera");
		Integer restoranId =new Integer(req.getParameter("restorani"));
		
		req.setAttribute("restorani", restDao.findAll());
		
		if (ime == null || "".equals(ime) || prezime == null || "".equals(prezime) || mail == null || "".equals(mail) || lozinka == null || "".equals(lozinka) || adresa == null || "".equals(adresa)) {
			req.setAttribute("porukaPodaci", "Morate popuniti sve podatke");
			//System.out.println("nje isprav");
			//resp.sendRedirect(resp.encodeURL("./registracija.jsp"));
			RequestDispatcher disp = req.getRequestDispatcher("dodavanje_menadzera.jsp");
			disp.forward(req, resp);
			return;
		} 
		
		
		
		if (menRestDao.mailPostoji(mail)) {
			System.out.println("POSTOJI!!!!");
			req.setAttribute("porukaMail", "Mail vec postoji, morati izabrati drugaciji mail");
			RequestDispatcher disp = req.getRequestDispatcher("dodavanje_menadzera.jsp");
			disp.forward(req, resp);
			return;
		} else {
			System.out.println("NJE POSTOJI ");
		}
			
		
		MenadzerRestorana menRest = new MenadzerRestorana();
		
		menRest.setIme(ime);
		menRest.setPrezime(prezime);
		menRest.setMail(mail);
		menRest.setLozinka(lozinka);
		menRest.setAdresa(adresa);
		menRest.setSlika("neut.jpg");
		menRest.setRestoran(restDao.findById(restoranId));
		
		menRestDao.persist(menRest);
		
		
		req.setAttribute("porukaDodato", "Uspesno ste dodali menadzera restorana");
		
		//getServletContext().getRequestDispatcher("/OdjavaServlet").forward(req, resp);
		RequestDispatcher disp = req.getRequestDispatcher("dodavanje_menadzera.jsp");
		disp.forward(req, resp);
		
		
	}
	
	
}
