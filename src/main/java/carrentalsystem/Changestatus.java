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
		  
		int bid = 0;
		int cid = 0;

		try {
		    bid = Integer.parseInt(req.getParameter("bid"));
		    cid = Integer.parseInt(req.getParameter("cid"));
		} catch (Exception e) {
		    e.printStackTrace();
		    resp.getWriter().print("Invalid booking or car ID");
		    return; // stop execution
		}
		  
		    EntityManager em = JPAUtil.getEntityManager();
			EntityTransaction et=em.getTransaction();
			
			et.begin();
			
			
//			making a booked car available means updating car status as available and removing booking
			Car c=em.find(Car.class, cid);
			if(c != null){
			    c.setStatus(Constants.AVAILABLE);
			}
			
			
			Booking b = em.find(Booking.class, bid);
			if(b != null){
			    em.remove(b);
			}
			em.remove(b);
			
			et.commit();
			
			
			  RequestDispatcher rd=req.getRequestDispatcher("listofbooking");
			  rd.forward(req, resp);
			  em.close();
		  
	}
}

