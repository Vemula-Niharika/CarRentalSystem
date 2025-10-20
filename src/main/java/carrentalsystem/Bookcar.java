package carrentalsystem;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/bookcar")
public class Bookcar extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int carid=Integer.parseInt(req.getParameter("carid"));
		String username=req.getParameter("uname");
		String sdate=req.getParameter("sdate");
		String edate=req.getParameter("edate");
		
		Booking booking=new Booking(carid,username,sdate,edate);

		EntityManagerFactory emf=Persistence.createEntityManagerFactory("carrental");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		 em.persist(booking);
		 
		 Car car=em.find(Car.class, carid);
		 car.setStatus("booked");
		 
		et.commit();
		
		
		resp.sendRedirect("listofbooking");

		
		
	}
}
