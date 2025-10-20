package carrentalsystem;

import java.io.IOException;
import java.util.List;

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

@WebServlet("/listofbooking")
public class Listofbooking extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("carrental");

		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
//		et.begin();
		String query="select b from Booking b ";
		
		  List<Booking> bookinglist=em.createQuery(query,Booking.class).getResultList();
		  
		  
//		  resp.sendRedirect("listofbooking"); 
		  req.setAttribute("bookinglist",bookinglist);
		  RequestDispatcher rd = req.getRequestDispatcher("listofbooking.jsp");
		  rd.forward(req, resp);
	}
}
