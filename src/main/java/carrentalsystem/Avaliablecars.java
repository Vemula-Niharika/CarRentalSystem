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
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("carrental");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	
//	et.begin();
	String query="select c from Car c where c.status=:stat";
	
	  List<Car> carlist=em.createQuery(query,Car.class).setParameter("stat","available").getResultList();
	  
	  System.out.println(carlist);
	  
	  req.setAttribute("carlist", carlist);
  
	  RequestDispatcher rd = req.getRequestDispatcher("availablecars.jsp");


  rd.forward(req, resp);
	  
}
}

