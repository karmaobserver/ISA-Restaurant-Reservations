package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.persistence.NoResultException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.MenadzerRestorana;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.MenadzerSistema;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.MenadzerSistemaDaoLocal;

public class LoginMenadzerSistemaServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8314860697907849727L;

	@EJB
	private MenadzerSistemaDaoLocal menadzerSistemaDao;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		MenadzerSistema menSisUSesiji = (MenadzerSistema)req.getSession().getAttribute("menadzerSistema"); 
		if(menSisUSesiji!=null){
			System.out.println("SESIJA NIJE NULL SIS");
			 RequestDispatcher disp = req.getRequestDispatcher("home.jsp");
			 disp.forward(req, resp);
			 return;
		}
		
		try {
			String mail = req.getParameter("mail");
			String lozinka = req.getParameter("lozinka");
			
			MenadzerSistema menadzerSistema = menadzerSistemaDao.logovanjeMenadzerSistema(mail, lozinka);
			
			
			
			
			if(menadzerSistema != null) {
				System.out.println("NUULLL Sistema");
				//HttpSession session = req.getSession(true);
				req.getSession().setAttribute("menadzerSistema", menadzerSistema);
				System.out.println(menadzerSistema.getIme());
				
				 RequestDispatcher disp = req.getRequestDispatcher("home.jsp");
				 disp.forward(req, resp);
				//getServletContext().getRequestDispatcher("prikaz.jsp").forward(request, response);
				
			}
			
			} catch (EJBException e) {
				if (e.getCause().getClass().equals(NoResultException.class)) {
					req.setAttribute("poruka", "Pogresna sifra ili mail adresa!");
					req.getRequestDispatcher("login_menadzer_sistema.jsp").forward(req, resp);
				} else {
					throw e;
				}
			
			}
		
		
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
