package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.servlet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Gost;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Rezervacija;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.RezervacijaDaoLocal;

public class PrikazPosecenihRestoranaServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2739202926340745296L;
	
	@EJB
	private RezervacijaDaoLocal rezDao;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Gost gostUSesiji = (Gost)req.getSession().getAttribute("gost"); 
		
		
		if(gostUSesiji==null){
			System.out.println("SESIJA je NULL SIS");
			 RequestDispatcher disp = req.getRequestDispatcher("login.jsp");
			 disp.forward(req, resp);
			 return;
		}
		
		List<Rezervacija> listaRezervacija = rezDao.nadjiRezervacijeZaGosta(gostUSesiji);
		req.setAttribute("listaRezervacija", listaRezervacija);
		
		req.getRequestDispatcher("prikaz_posecenih_restorana.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
