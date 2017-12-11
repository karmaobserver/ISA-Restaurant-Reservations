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


public class PrijateljiServlet extends HttpServlet
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8337448365984873912L;
	
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
		
		String saPrijatelja = req.getParameter("saPrijatelja");
		System.out.println("SA PRIJATELJA :" + saPrijatelja  );
		
		Integer id_gosta = new Integer(req.getParameter("id"));
		//String id_gosta = req.getParameter("id");
		
		System.out.println("KOJI ID" + id_gosta);
		
		Gost gostZaDodati = gostDao.findById(id_gosta);
		
		System.out.println("NADJEN GOST: " + gostZaDodati);
		//gostUSesiji.getPrijatelji().add(gostZaDodati);
		
		//gostDao.ucitajPrijatelje(gostUSesiji);
		//System.out.println("Prijatelji: " + gostDao.ucitajPrijatelje(gostUSesiji));
		
		ArrayList<Gost> lista = gostDao.dodajPrijatelja(gostUSesiji, gostZaDodati);
		
		gostDao.merge(lista.get(0));
		gostDao.merge(lista.get(1));
	
		
		
		if(saPrijatelja!=null) {
			//req.getRequestDispatcher("prijatelji.jsp").forward(req, resp);
			 RequestDispatcher disp = req.getRequestDispatcher("PrijateljiPrijateljiServlet");
			 disp.forward(req, resp);
			 return;
		}
		
		req.getRequestDispatcher("MojNalogServlet").forward(req, resp);
		
		
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
