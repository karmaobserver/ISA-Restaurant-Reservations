package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.MenadzerRestorana;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Restoran;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.RestoranDaoLocal;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.StolDaoLocal;

public class RasporedServlet  extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 806410082767772452L;
	
	@EJB
	private RestoranDaoLocal restDao;
	
	@EJB
	private StolDaoLocal stolDao;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MenadzerRestorana menRestUSesiji = (MenadzerRestorana)req.getSession().getAttribute("menadzerRestorana"); 
		
		
		if(menRestUSesiji==null){
			System.out.println("SESIJA je NULL SIS");
			 RequestDispatcher disp = req.getRequestDispatcher("login.jsp");
			 disp.forward(req, resp);
			 return;
		}
		
		Integer id_restorana = new Integer(req.getParameter("id"));
		
		req.getSession().setAttribute("restoranUSesiji",  restDao.findById(id_restorana));
		
		
		//req.setAttribute("stolovi", stolDao.findAll());
		req.setAttribute("stolovi", stolDao.nadjiStoloveZaOdredjenRestoran(id_restorana));
		
		RequestDispatcher disp = req.getRequestDispatcher("raspored.jsp");
		disp.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MenadzerRestorana menRestUSesiji = (MenadzerRestorana)req.getSession().getAttribute("menadzerRestorana"); 
		Restoran restUSesiji = (Restoran) req.getSession().getAttribute("restoranUSesiji");
		if(menRestUSesiji==null){
			System.out.println("SESIJA je NULL SIS");
			 RequestDispatcher disp = req.getRequestDispatcher("login.jsp");
			 disp.forward(req, resp);
			 return;
		}
		
		Integer kolona = new Integer(req.getParameter("kolona"));
		Integer redova = new Integer(req.getParameter("redova"));
	
		
		//Jelo jeloUSesiji = (Jelo) req.getSession().getAttribute("jeloSesija");
		
		if (kolona == null || "".equals(kolona) || redova == null || "".equals(redova)) {
			req.setAttribute("porukaPodaci", "Polje ne sme biti prazno");
			RequestDispatcher disp = req.getRequestDispatcher("raspored.jsp");
			disp.forward(req, resp);
			return;

		}
		
		//Restoran restoran = new Restoran();
		
		
		restUSesiji.setKolona(kolona);
		restUSesiji.setRedova(redova);
		
		restDao.merge(restUSesiji);
		
		//req.setAttribute("porukaDodato", "Uspesno ste dodali jelo");
		
		RequestDispatcher disp = req.getRequestDispatcher("konfiguracija_stolova.jsp");
		disp.forward(req, resp);
		
	}
}
