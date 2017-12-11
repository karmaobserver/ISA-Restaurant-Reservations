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
import javax.servlet.http.HttpSession;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Gost;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.MenadzerRestorana;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.MenadzerRestoranaDaoLocal;

public class LoginMenadzerRestoranaServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6904458191275350541L;

	@EJB
	private MenadzerRestoranaDaoLocal menadzerRestoranaDao;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		MenadzerRestorana menRestUSesiji = (MenadzerRestorana)req.getSession().getAttribute("menadzerRestorana"); 
		if(menRestUSesiji!=null){
			System.out.println("SESIJA NIJE NULL REST");
			 RequestDispatcher disp = req.getRequestDispatcher("home.jsp");
			 disp.forward(req, resp);
			 return;
		}
		
		try {
			String mail = req.getParameter("mail");
			String lozinka = req.getParameter("lozinka");
			
			MenadzerRestorana menadzerRestorana = menadzerRestoranaDao.logovanjeMenadzerRestorana(mail, lozinka);
			
			
			
			
			if(menadzerRestorana != null) {
				System.out.println("NUULLL REST");
				//HttpSession session = req.getSession(true);
				req.getSession().setAttribute("menadzerRestorana", menadzerRestorana);
				System.out.println(menadzerRestorana.getIme());
				
				 RequestDispatcher disp = req.getRequestDispatcher("home.jsp");
				 disp.forward(req, resp);
				//getServletContext().getRequestDispatcher("prikaz.jsp").forward(request, response);
				
			}
			
			} catch (EJBException e) {
				if (e.getCause().getClass().equals(NoResultException.class)) {
					req.setAttribute("poruka", "Pogresna sifra ili mail adresa!");
					req.getRequestDispatcher("login_menadzer_restorana.jsp").forward(req, resp);
				} else {
					throw e;
				}
			
			}
			
		}	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
}
