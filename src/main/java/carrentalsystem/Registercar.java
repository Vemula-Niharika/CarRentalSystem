package carrentalsystem;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/registration")
public class Registercar extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int regCarId= Integer.parseInt(req.getParameter("regCarId"));
		String regCarName =req.getParameter("regCarName");
		String regCarModel =req.getParameter("regCarModel");
		int regCarNumber= Integer.parseInt(req.getParameter("regCarNumber"));
		String regOwnerName =req.getParameter("regOwnerName");
		
		Car c=new Car(regCarId, regCarName, regCarModel, regCarNumber, "available", regOwnerName);
		
		
		PrintWriter pw=resp.getWriter();
		pw.print("data entered");
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("carrental");
		EntityManager em= emf.createEntityManager();
		EntityTransaction et= em.getTransaction();
		

		et.begin();
		  em.persist(c);
		et.commit();
	}
	

}
