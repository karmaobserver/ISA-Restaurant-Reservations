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
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.GostDaoLocal;

public class PretrazivanjePrijateljaServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8157137776824467395L;
	
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
		
		req.getRequestDispatcher("moj_nalog.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Gost gostUSesiji = (Gost)req.getSession().getAttribute("gost"); 
		
		
		if(gostUSesiji==null){
			System.out.println("SESIJA je NULL SIS");
			 RequestDispatcher disp = req.getRequestDispatcher("login.jsp");
			 disp.forward(req, resp);
			 return;
		}
		
		String saPrijatelja = req.getParameter("saPrijatelja");
		System.out.println("SA PRIJATELJA :" + saPrijatelja  );
		
		String imePrzime = req.getParameter("imePrzime");
		
		List<Gost> lista = gostDao.nadjiPoImenuGosta(imePrzime);
		
		req.setAttribute("lista", lista);
		
		req.setAttribute("gosti", gostDao.findAll());
		
		//ucitavam prijatelje
		req.setAttribute("prijateljiGost", gostDao.ucitajPrijatelje(gostUSesiji));
		
		if(saPrijatelja!=null) {
			//req.getRequestDispatcher("prijatelji.jsp").forward(req, resp);
			 RequestDispatcher disp = req.getRequestDispatcher("prijatelji.jsp");
			 disp.forward(req, resp);
			 return;
		}
		//req.getRequestDispatcher("moj_nalog.jsp").forward(req, resp);
		 RequestDispatcher disp = req.getRequestDispatcher("moj_nalog.jsp");
		 disp.forward(req, resp);
		
		
	}

}
