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
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.GostDaoLocal;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.MenadzerRestoranaDaoLocal;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.MenadzerSistemaDaoLocal;

public class IzmenaNalogaServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8013439641988642568L;
	
	@EJB
	private GostDaoLocal gostDao;
	@EJB
	private MenadzerRestoranaDaoLocal menRestDao;
	
	@EJB
	private MenadzerSistemaDaoLocal menSisDao;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ulazi u get Izmena");
		MenadzerSistema menSisUSesiji = (MenadzerSistema)req.getSession().getAttribute("menadzerSistema"); 
		MenadzerRestorana menRestUSesiji = (MenadzerRestorana)req.getSession().getAttribute("menadzerRestorana");
		Gost gostUSesiji = (Gost)req.getSession().getAttribute("gost"); 
		
	
		
		if(gostUSesiji != null) {
			req.getRequestDispatcher("izmena_naloga.jsp").forward(req, resp);
			
			
		} else if (menRestUSesiji != null) {
			req.getRequestDispatcher("izmena_naloga.jsp").forward(req, resp);
			
		} else if (menSisUSesiji != null) {
			req.getRequestDispatcher("izmena_naloga.jsp").forward(req, resp);
			
		} else {
			System.out.println("Sesija je NULL");
			 RequestDispatcher disp = req.getRequestDispatcher("login.jsp");
			 disp.forward(req, resp);
			 return;
			
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("usao u post Izmena");
		
		MenadzerSistema menSisUSesiji = (MenadzerSistema)req.getSession().getAttribute("menadzerSistema"); 
		MenadzerRestorana menRestUSesiji = (MenadzerRestorana)req.getSession().getAttribute("menadzerRestorana");
		Gost gostUSesiji = (Gost)req.getSession().getAttribute("gost"); 
		
	
		
		if(gostUSesiji != null) {
			

			String ime = req.getParameter("ime");
			String prezime = req.getParameter("prezime");
			String mail = req.getParameter("mail");
			String lozinka = req.getParameter("lozinka");
			String adresa = req.getParameter("adresa");
			
			
			if (ime == null || "".equals(ime) || prezime == null || "".equals(prezime) || mail == null || "".equals(mail) || lozinka == null || "".equals(lozinka) || adresa == null || "".equals(adresa)) {
				req.setAttribute("porukaPodaci","Polje ne sme biti prazno");
				RequestDispatcher disp = req.getRequestDispatcher("izmena_naloga.jsp");
				disp.forward(req, resp);
				return;

			}
			
			if (!gostUSesiji.getMail().equals(mail)) {	//dal smo menjali mail
				//System.out.println("RAZLICIT");
				if (gostDao.mailPostoji(mail)) {	//dal postoji u bazi novi mail
					//System.out.println("POSTOJI!!!!");
					req.setAttribute("porukaMail", "Mail vec postoji, morati izabrati drugaciji mail");
					RequestDispatcher disp = req.getRequestDispatcher("izmena_naloga.jsp");
					disp.forward(req, resp);
					return;
				} else {
					System.out.println("NJE POSTOJI ");
				}
			}
			//System.out.println("NIJE BIO RAZLICIT?");
			//Gost gost = new Gost();
			
			gostUSesiji.setIme(ime);
			gostUSesiji.setPrezime(prezime);
			gostUSesiji.setMail(mail);
			gostUSesiji.setLozinka(lozinka);
			gostUSesiji.setAdresa(adresa);
			//gost.setBrojPoseta(1);
			//gost.setSlika("neut.jpg");
			
			System.out.println("Dolazi do merge");
			gostDao.merge(gostUSesiji);
			
			req.setAttribute("porukaIzmene", "Uspesno ste izmenili podatke");
			
			
			req.getRequestDispatcher("izmena_naloga.jsp").forward(req, resp);
			
			
		} else if (menRestUSesiji != null) {
			
			String ime = req.getParameter("imeRest");
			String prezime = req.getParameter("prezimeRest");
			String mail = req.getParameter("mailRest");
			String lozinka = req.getParameter("lozinkaRest");
			String adresa = req.getParameter("adresaRest");
			
			if (ime == null || "".equals(ime) || prezime == null || "".equals(prezime) || mail == null || "".equals(mail) || lozinka == null || "".equals(lozinka) || adresa == null || "".equals(adresa)) {
				req.setAttribute("porukaPodaci", "Polje ne sme biti prazno");
				RequestDispatcher disp = req.getRequestDispatcher("izmena_naloga.jsp");
				disp.forward(req, resp);
				return;

			}
			
			if (!menRestUSesiji.getMail().equals(mail)) {
				if (menRestDao.mailPostoji(mail)) {
					//System.out.println("POSTOJI!!!!");
					req.setAttribute("porukaMail", "Mail vec postoji, morati izabrati drugaciji mail");
					RequestDispatcher disp = req.getRequestDispatcher("izmena_naloga.jsp");
					disp.forward(req, resp);
					return;
				} else {
					System.out.println("NJE POSTOJI ");
				}
			}
			//Gost gost = new Gost();
			
			menRestUSesiji.setIme(ime);
			menRestUSesiji.setPrezime(prezime);
			menRestUSesiji.setMail(mail);
			menRestUSesiji.setLozinka(lozinka);
			menRestUSesiji.setAdresa(adresa);
			//menRestUSesiji.setBrojPoseta(1);
			//menRestUSesiji.setSlika("neut.jpg");
			
			System.out.println("Dolazi do merge");
			menRestDao.merge(menRestUSesiji);
			
			req.setAttribute("porukaIzmene", "Uspesno ste izmenili podatke");
			
			req.getRequestDispatcher("izmena_naloga.jsp").forward(req, resp);
			
		} else if (menSisUSesiji != null) {
			
			
			String ime = req.getParameter("imeSis");
			String prezime = req.getParameter("prezimeSis");
			String mail = req.getParameter("mailSis");
			String lozinka = req.getParameter("lozinkaSis");
			String adresa = req.getParameter("adresaSis");
			
			if (ime == null || "".equals(ime) || prezime == null || "".equals(prezime) || mail == null || "".equals(mail) || lozinka == null || "".equals(lozinka) || adresa == null || "".equals(adresa)) {
				req.setAttribute("porukaPodaci", "Polje ne sme biti prazno");
				RequestDispatcher disp = req.getRequestDispatcher("izmena_naloga.jsp");
				disp.forward(req, resp);
				return;

			}
			
			if (!menSisUSesiji.getMail().equals(mail)) {
				if (menSisDao.mailPostoji(mail)) {
					//System.out.println("POSTOJI!!!!");
					req.setAttribute("porukaMail", "Mail vec postoji, morati izabrati drugaciji mail");
					RequestDispatcher disp = req.getRequestDispatcher("izmena_naloga.jsp");
					disp.forward(req, resp);
					return;
				} else {
					System.out.println("NJE POSTOJI ");
				}
			}
			//Gost gost = new Gost();
			
			menSisUSesiji.setIme(ime);
			menSisUSesiji.setPrezime(prezime);
			menSisUSesiji.setMail(mail);
			menSisUSesiji.setLozinka(lozinka);
			menSisUSesiji.setAdresa(adresa);
			//menSisUSesiji.setBrojPoseta(1);
			//menSisUSesiji.setSlika("neut.jpg");
			
			System.out.println("Dolazi do merge");
			menSisDao.merge(menSisUSesiji);
			
			req.setAttribute("porukaIzmene", "Uspesno ste izmenili podatke");
			
			
			req.getRequestDispatcher("izmena_naloga.jsp").forward(req, resp);
			
		} else {
			System.out.println("Sesija je NULL");
			 RequestDispatcher disp = req.getRequestDispatcher("login.jsp");
			 disp.forward(req, resp);
			 return;
			
		}
		
		
	}
}
