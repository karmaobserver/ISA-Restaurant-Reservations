package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Gost;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.GostDaoLocal;

public class ObrisiPrijateljaServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7427962046695658795L;
	
	@EJB
	private GostDaoLocal gostDao;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Gost gostUSesiji = (Gost)req.getSession().getAttribute("gost"); 
		
		
		if(gostUSesiji==null){
			System.out.println("SESIJA je NULL SIS");
			 RequestDispatcher disp = req.getRequestDispatcher("login.jsp");
			 disp.forward(req, resp);
			 return;
		}
		
		Integer id_gosta = new Integer(req.getParameter("id"));
		//String id_gosta = req.getParameter("id");
		
		System.out.println("KOJI ID" + id_gosta);
		
		Gost gostZaObrisati = gostDao.findById(id_gosta);
		
		System.out.println("NADJEN GOST: " + gostZaObrisati);
		//gostUSesiji.getPrijatelji().add(gostZaDodati);
		
		//gostDao.ucitajPrijatelje(gostUSesiji);
		//System.out.println("Prijatelji: " + gostDao.ucitajPrijatelje(gostUSesiji));
		
		//ArrayList<Gost> lista = gostDao.dodajPrijatelja(gostUSesiji, gostZaDodati);
		
		//gostDao.merge(lista.get(0));
		//gostDao.merge(lista.get(1));
		
		gostDao.izbrisiPrijatelja(gostUSesiji, gostZaObrisati);
	
		
		
		req.getRequestDispatcher("PrijateljiPrijateljiServlet").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
