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
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.RestoranDaoLocal;

public class PrikazRestoranaServlet extends HttpServlet{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9205474096662173101L;
	
	@EJB
	private RestoranDaoLocal restoranDao;
	@EJB
	private MenadzerRestoranaDaoLocal menRestDao;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		MenadzerSistema menSisUSesiji = (MenadzerSistema)req.getSession().getAttribute("menadzerSistema"); 
		MenadzerRestorana menRestUSesiji = (MenadzerRestorana)req.getSession().getAttribute("menadzerRestorana");
		Gost gostUSesiji = (Gost)req.getSession().getAttribute("gost"); 
		
	
		//Integer id_restorana = new Integer(req.getParameter("id"));
		
		
		if(gostUSesiji != null) {
			
			
			
			
			req.setAttribute("restorani", restoranDao.findAll());
			
			
			req.getRequestDispatcher("prikaz_restorana.jsp").forward(req, resp);
			
			
		} else if (menRestUSesiji != null) {
			
			Integer id_restorana = new Integer(req.getParameter("id"));
			
			
			System.out.println("ID RESTORANA:"+ id_restorana);
			
			//Restoran restoran = restoranDao.nadjiRestoranZaId(id_restorana);
			
			
			req.setAttribute("restoranId", restoranDao.findById(id_restorana));
			req.getSession().setAttribute("restoranId",  restoranDao.findById(id_restorana));
			
			
			
			
			//System.out.println("STA POKUPIM:" + restoranDao.nadjiRestoranZaId(id_restorana));
			//System.out.println("ONA DRUGA :" +  restoranDao.findById(id_restorana));
			req.getRequestDispatcher("prikaz_restorana.jsp").forward(req, resp);
				
		} else if (menSisUSesiji != null) {
			
			//request.setAttribute("vozila", voziloDao.findAll());
			req.setAttribute("restorani", restoranDao.findAll());
			
			req.setAttribute("menadzeriRestorana", menRestDao.findAll());
			
			
			
			req.getRequestDispatcher("prikaz_restorana.jsp").forward(req, resp);
			
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
