package carrentalsystem;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/changestatus")
public class Changestatus extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  
		  int bid=Integer.parseInt(req.getParameter("bid"));
		  int cid=Integer.parseInt(req.getParameter("cid"));
		  
		  EntityManagerFactory emf=Persistence.createEntityManagerFactory("carrental");
			EntityManager em=emf.createEntityManager();
			EntityTransaction et=em.getTransaction();
			
			et.begin();
			Car c=em.find(Car.class, cid);
			c.setStatus("available");
			
			Booking b=em.find(Booking.class, bid);
			em.remove(b);
			
			et.commit();
			
			
			  RequestDispatcher rd=req.getRequestDispatcher("listofbooking");
			  rd.forward(req, resp);
		  
	}
}

