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

public class MojNalogServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5196424374661399033L;
	
	@EJB
	private GostDaoLocal gostDao;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//System.out.println("get");
		MenadzerSistema menSisUSesiji = (MenadzerSistema)req.getSession().getAttribute("menadzerSistema"); 
		MenadzerRestorana menRestUSesiji = (MenadzerRestorana)req.getSession().getAttribute("menadzerRestorana");
		Gost gostUSesiji = (Gost)req.getSession().getAttribute("gost"); 
		
	
		
		if(gostUSesiji != null) {
			
			req.setAttribute("gosti", gostDao.findAll());
			
			//ucitavam prijatelje
			req.setAttribute("prijateljiGost", gostDao.ucitajPrijatelje(gostUSesiji));
			
			//gostUSesiji.dodajPrijatelja(k);
			req.getRequestDispatcher("moj_nalog.jsp").forward(req, resp);
			
			
		} else if (menRestUSesiji != null) {
			req.getRequestDispatcher("moj_nalog.jsp").forward(req, resp);
			
		} else if (menSisUSesiji != null) {
			req.getRequestDispatcher("moj_nalog.jsp").forward(req, resp);
			
		} else {
			System.out.println("Sesija je NULL");
			 RequestDispatcher disp = req.getRequestDispatcher("login.jsp");
			 disp.forward(req, resp);
			 return;
			
		}
		
	/*	if(menSisUSesiji == null){
			System.out.println("SESIJA je NULL za Sis");
			 RequestDispatcher disp = req.getRequestDispatcher("login.jsp");
			 disp.forward(req, resp);
			 return;
		}
		
		MenadzerRestorana menRestUSesiji = (MenadzerRestorana)req.getSession().getAttribute("menadzerRestorana"); 
		if(menRestUSesiji == null){
			System.out.println("SESIJA je NULL za Rest");
			 RequestDispatcher disp = req.getRequestDispatcher("login.jsp");
			 disp.forward(req, resp);
			 return;
		}*/
		
	
		
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("post");
	}
}
