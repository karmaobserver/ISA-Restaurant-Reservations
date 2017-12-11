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

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.JeloDaoLocal;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.RestoranDaoLocal;

public class JelovnikServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3147531707632682360L;
	
	@EJB
	private JeloDaoLocal jeloDao;
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
			
			
			req.setAttribute("saPosecenihRestorana", req.getParameter("poseceni"));
			
			req.setAttribute("jela", jeloDao.nadjiJelaZaRestoranID(id_restorana));
			req.getRequestDispatcher("prikaz_jelovnik.jsp").forward(req, resp);
			
			
		} else if (menRestUSesiji != null) {
			req.setAttribute("jela", jeloDao.nadjiJelaZaRestoranID(id_restorana));
			System.out.println("REZULTAT: " +jeloDao.nadjiJelaZaRestoranID(id_restorana));
			
			req.getRequestDispatcher("prikaz_jelovnik.jsp").forward(req, resp);
			
		} else if (menSisUSesiji != null) {
			
			
			req.setAttribute("jela", jeloDao.nadjiJelaZaRestoranID(id_restorana));
			System.out.println("REZULTAT: " +jeloDao.nadjiJelaZaRestoranID(id_restorana));
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
		doGet(req, resp);;
	}
}
