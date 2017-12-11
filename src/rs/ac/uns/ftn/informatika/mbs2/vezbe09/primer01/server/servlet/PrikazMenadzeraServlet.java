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
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.MenadzerRestoranaDaoLocal;

public class PrikazMenadzeraServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -876512054524532759L;
	
	@EJB
	private MenadzerRestoranaDaoLocal menRestDao;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MenadzerSistema menSisUSesiji = (MenadzerSistema)req.getSession().getAttribute("menadzerSistema"); 
		MenadzerRestorana menRestUSesiji = (MenadzerRestorana)req.getSession().getAttribute("menadzerRestorana");
		Gost gostUSesiji = (Gost)req.getSession().getAttribute("gost"); 
		
	
		
		if(gostUSesiji != null) {
			req.getRequestDispatcher("prikaz_menadzera.jsp").forward(req, resp);
			
			
		} else if (menRestUSesiji != null) {
			req.getRequestDispatcher("prikaz_menadzera.jsp").forward(req, resp);
			
		} else if (menSisUSesiji != null) {
			
			
			
			
			req.setAttribute("menadzeriRestorana", menRestDao.findAll());
			
			req.getRequestDispatcher("prikaz_menadzera.jsp").forward(req, resp);
			
		} else {
			System.out.println("Sesija je NULL");
			 RequestDispatcher disp = req.getRequestDispatcher("login.jsp");
			 disp.forward(req, resp);
			 return;
			
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
