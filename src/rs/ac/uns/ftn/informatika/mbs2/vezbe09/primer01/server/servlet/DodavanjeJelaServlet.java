package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Jelo;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.MenadzerRestorana;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Restoran;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.JeloDaoLocal;

public class DodavanjeJelaServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5242582878740253225L;
	
	@EJB
	private JeloDaoLocal jeloDao;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MenadzerRestorana menRestUSesiji = (MenadzerRestorana)req.getSession().getAttribute("menadzerRestorana"); 
		Restoran restUSesiji = (Restoran) req.getSession().getAttribute("restoranId");
		if(menRestUSesiji==null){
			System.out.println("SESIJA je NULL SIS");
			 RequestDispatcher disp = req.getRequestDispatcher("login.jsp");
			 disp.forward(req, resp);
			 return;
		}
		
		
		
		RequestDispatcher disp = req.getRequestDispatcher("dodavanje_jela.jsp");
		disp.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MenadzerRestorana menRestUSesiji = (MenadzerRestorana)req.getSession().getAttribute("menadzerRestorana"); 
		Restoran restoranId = (Restoran) req.getSession().getAttribute("restoranId");
		
		
		if(menRestUSesiji==null){
			System.out.println("SESIJA je NULL SIS");
			 RequestDispatcher disp = req.getRequestDispatcher("login.jsp");
			 disp.forward(req, resp);
			 return;
		}
		
		String naziv = req.getParameter("nazivJela");
		String opis = req.getParameter("opisJela");
		Double cena = new Double(req.getParameter("cenaJela"));
		
		//Jelo jeloUSesiji = (Jelo) req.getSession().getAttribute("jeloSesija");
		
		if (naziv == null || "".equals(naziv) || opis == null || "".equals(opis) || cena == null || "".equals(cena)) {
			req.setAttribute("porukaPodaci", "Polje ne sme biti prazno");
			RequestDispatcher disp = req.getRequestDispatcher("dodavanje_jela.jsp");
			disp.forward(req, resp);
			return;

		}
		
		Jelo jelo = new Jelo();
		
		jelo.setNazivJela(naziv);
		jelo.setOpisJela(opis);
		jelo.setCenaJela(cena);
		jelo.setRestoran(restoranId);
		
		jeloDao.persist(jelo);
		
		req.setAttribute("porukaDodato", "Uspesno ste dodali jelo");
		
		RequestDispatcher disp = req.getRequestDispatcher("dodavanje_jela.jsp");
		disp.forward(req, resp);
		
		
	}
}
