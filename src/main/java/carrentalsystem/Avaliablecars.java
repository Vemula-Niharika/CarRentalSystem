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

@WebServlet("/availablecars")
public class Avaliablecars extends HttpServlet{
	
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	
	
//	create emf for hibernate
	EntityManager em = JPAUtil.getEntityManager();
	
//	prepare  query to get only available car
//	jpql query fetches only cars whose status is available
	
	
	String query="select c from Car c where c.status=:stat";
	
	  List<Car> carlist=em.createQuery(query,Car.class).setParameter("stat","available").getResultList();
	  
	  System.out.println("Fetched available cars: " + carlist.size());
	  
	  
	  
//	  stores list of cars in request
	  req.setAttribute("carlist", carlist);
  
	  RequestDispatcher rd = req.getRequestDispatcher("availablecars.jsp");


      rd.forward(req, resp);
  
//  servlet fetches data ,stores in request uing setAttribute,forwards to JSP , JSP reads request to display data
  em.close();
}
}

