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

public class ObrisiServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 710269025134760110L;
	
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
			
			
			Integer id_jela = new Integer(req.getParameter("idJela"));
			
			Jelo jelo = jeloDao.findById(id_jela);
			jeloDao.remove(jelo);
			
			Restoran restoranId = (Restoran) req.getSession().getAttribute("restoranId");
			
			req.getRequestDispatcher("JelovnikServlet?id="+ restoranId.getId_restoran()).forward(req, resp);
			
		} else if (menSisUSesiji != null) {
			
			
			
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
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
