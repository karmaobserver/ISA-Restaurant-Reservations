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

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Gost;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Korisnik;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.GostDaoLocal;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.KorisnikDaoLocal;

public class LoginServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5312666997744744896L;
	@EJB
	private GostDaoLocal gostDao;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Gost gostUSesiji = (Gost)req.getSession().getAttribute("gost"); 
		if(gostUSesiji!=null){
			System.out.println("SESIJA NIJE NULL");
			 RequestDispatcher disp = req.getRequestDispatcher("home.jsp");
			 disp.forward(req, resp);
			 return;
		}
		
		try {
		String mail = req.getParameter("mail");
		String lozinka = req.getParameter("lozinka");
		
		Gost gost = gostDao.logovanjeGost(mail, lozinka);
		
		
		
		
		if(gost != null) {
			//HttpSession session = req.getSession();
		
			
			req.getSession().setAttribute("gost", gost);
			System.out.println(gost.getIme());
			
			 RequestDispatcher disp = req.getRequestDispatcher("PrikazPosecenihRestoranaServlet");
			 disp.forward(req, resp);
			//getServletContext().getRequestDispatcher("prikaz.jsp").forward(request, response);
			
		}
		
		} catch (EJBException e) {
			if (e.getCause().getClass().equals(NoResultException.class)) {
				req.setAttribute("poruka", "Pogresna sifra ili mail adresa!");
				req.getRequestDispatcher("login_gost.jsp").forward(req, resp);
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
