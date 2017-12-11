package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Gost;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Jelo;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.MenadzerRestorana;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.MenadzerSistema;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Restoran;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.JeloDaoLocal;

public class IzmenaJelovnikaServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4839125448003752660L;
	
	@EJB
	private JeloDaoLocal jeloDao;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MenadzerSistema menSisUSesiji = (MenadzerSistema)req.getSession().getAttribute("menadzerSistema"); 
		MenadzerRestorana menRestUSesiji = (MenadzerRestorana)req.getSession().getAttribute("menadzerRestorana");
		Gost gostUSesiji = (Gost)req.getSession().getAttribute("gost"); 
	
		
		if(gostUSesiji != null) {
			req.getRequestDispatcher("prikaz_jelovnik.jsp").forward(req, resp);
			
			
		} else if (menRestUSesiji != null) {
			
			//Integer id_restorana = new Integer(req.getParameter("idRestJelovnik"));
		
			//req.setAttribute("jela", jeloDao.nadjiJelaZaRestoranID(id_restorana));
			//System.out.println("REZULTAT: " +jeloDao.nadjiJelaZaRestoranID(id_restorana));
			
			Integer id_jela = new Integer(req.getParameter("idJela"));
			 req.setAttribute("jeloPoId", jeloDao.findById(id_jela));
			req.getSession().setAttribute("jeloSesija", jeloDao.findById(id_jela));
			req.getRequestDispatcher("izmena_jelovnika.jsp").forward(req, resp);
			
		} else if (menSisUSesiji != null) {
			
			
		//	req.setAttribute("jela", jeloDao.nadjiJelaZaRestoranID(id_restorana));
		//	System.out.println("REZULTAT: " +jeloDao.nadjiJelaZaRestoranID(id_restorana));
			req.getRequestDispatcher("prikaz_jelovnik.jsp").forward(req, resp);
			
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
		Restoran restoranId = (Restoran) req.getSession().getAttribute("restoranId");
	
		
		if(gostUSesiji != null) {

			req.getRequestDispatcher("izmena_naloga.jsp").forward(req, resp);
			
		} else if (menRestUSesiji != null) {
			
			String naziv = req.getParameter("nazivJela");
			String opis = req.getParameter("opisJela");
			Double cena = new Double(req.getParameter("cenaJela"));
			
			Jelo jeloUSesiji = (Jelo) req.getSession().getAttribute("jeloSesija");
			
			if (naziv == null || "".equals(naziv) || opis == null || "".equals(opis) || cena == null || "".equals(cena)) {
				req.setAttribute("porukaPodaci", "Polje ne sme biti prazno");
				RequestDispatcher disp = req.getRequestDispatcher("JelovnikServlet?id="+ restoranId.getId_restoran());
				disp.forward(req, resp);
				return;

			}
			
			
			
			jeloUSesiji.setNazivJela(naziv);
			jeloUSesiji.setOpisJela(opis);
			jeloUSesiji.setCenaJela(cena);
			
			
			System.out.println("Dolazi do merge");
			jeloDao.merge(jeloUSesiji);
			
			req.setAttribute("porukaIzmene", "Uspesno ste izmenili podatke");
			
			//Integer id_restorana = (Integer) req.getSession().getAttribute("restoranId");
			
			//req.getRequestDispatcher("JelovnikServlet?id=" + id_restorana + ".jsp").forward(req, resp);
			

			
			
			req.getRequestDispatcher("JelovnikServlet?id="+ restoranId.getId_restoran()).forward(req, resp);
		} else if (menSisUSesiji != null) {
			
			
			req.getRequestDispatcher("izmena_jelovnika.jsp").forward(req, resp);
			
		} else {
			System.out.println("Sesija je NULL");
			 RequestDispatcher disp = req.getRequestDispatcher("login.jsp");
			 disp.forward(req, resp);
			 return;
			
		}
		
		
	}
	
}
