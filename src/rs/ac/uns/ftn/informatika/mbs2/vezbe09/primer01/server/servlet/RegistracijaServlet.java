package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Gost;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.GostDaoLocal;



public class RegistracijaServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4539036264432996647L;
	
	@EJB
	private GostDaoLocal gostDao;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//System.out.println("ulaz u GET tabela");
		
			
		
			String ime = req.getParameter("imeKorisnika");
			String prezime = req.getParameter("prezimeKorisnika");
			String mail = req.getParameter("mailKorisnika");
			String lozinka = req.getParameter("lozinkaKorisnika");
			String ponoviLozinka = req.getParameter("ponoviLozinkaKorisnika");
			
			if (ime == null || "".equals(ime) || prezime == null || "".equals(prezime) || mail == null || "".equals(mail) || lozinka == null || "".equals(lozinka) || ponoviLozinka == null || "".equals(ponoviLozinka)) {
				req.setAttribute("porukaPodaci", "Morate popuniti sve podatke");
				//System.out.println("nje isprav");
				//resp.sendRedirect(resp.encodeURL("./registracija.jsp"));
				RequestDispatcher disp = req.getRequestDispatcher("registracija.jsp");
				disp.forward(req, resp);
				return;
			} 
			
			if (!lozinka.equals(ponoviLozinka)) {
				req.setAttribute("porukaLozinka", "Lozinke se ne slazu");
				RequestDispatcher disp = req.getRequestDispatcher("registracija.jsp");
				disp.forward(req, resp);
				return;
			}
			
			if (gostDao.mailPostoji(mail)) {
				//System.out.println("POSTOJI!!!!");
				req.setAttribute("porukaMail", "Mail vec postoji, morati izabrati drugaciji mail");
				RequestDispatcher disp = req.getRequestDispatcher("registracija.jsp");
				disp.forward(req, resp);
				return;
			} else {
				System.out.println("NJE POSTOJI ");
			}
				
			
			Gost gost = new Gost();
			
			gost.setIme(ime);
			gost.setPrezime(prezime);
			gost.setMail(mail);
			gost.setLozinka(lozinka);
			gost.setAdresa("Nepoznata adresa");
			gost.setBrojPoseta(1);
			gost.setSlika("neut.jpg");
			
			gostDao.persist(gost);
			
			
			req.setAttribute("porukaReg", "Uspesno ste se registrovali, sada mozete da se prijavite na sistem.");
			
			//getServletContext().getRequestDispatcher("/OdjavaServlet").forward(req, resp);
			RequestDispatcher disp = req.getRequestDispatcher("login_gost.jsp");
			disp.forward(req, resp);
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
