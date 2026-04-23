package carrentalsystem;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/registration")
public class Registercar extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException {

	    int regCarId = 0;
	    int regCarNumber = 0;

	    // ✅ Step 1: Handle number input safely
	    try {
	        regCarId = Integer.parseInt(req.getParameter("regCarId"));
	        regCarNumber = Integer.parseInt(req.getParameter("regCarNumber"));
	    } catch (Exception e) {
	        e.printStackTrace();
	        resp.getWriter().print("Invalid Car ID or Car Number");
	        return;
	    }

	    // ✅ Step 2: Get other values
	    String regCarName = req.getParameter("regCarName");
	    String regCarModel = req.getParameter("regCarModel");
	    String regOwnerName = req.getParameter("regOwnerName");

	    // ✅ Step 3: Basic validation
	    if (regCarName == null || regCarName.isEmpty() ||
	        regCarModel == null || regCarModel.isEmpty() ||
	        regOwnerName == null || regOwnerName.isEmpty()) {

	        resp.getWriter().print("All fields are required!");
	        return;
	    }

	    EntityManager em = JPAUtil.getEntityManager();
	    EntityTransaction et = em.getTransaction();

	    try {

	        // ✅ 🔥 Step 4: CHECK DUPLICATE CAR NUMBER
	        String query = "select c from Car c where c.regCarNumber = :num";

	        java.util.List<Car> existingCars = em.createQuery(query, Car.class)
	                .setParameter("num", regCarNumber)
	                .getResultList();

	        if (!existingCars.isEmpty()) {
	            resp.getWriter().print("Car number already exists!");
	            return;
	        }

	        // ✅ Step 5: Create object
	        Car c = new Car(regCarId, regCarName, regCarModel,
	                regCarNumber, Constants.AVAILABLE, regOwnerName);

	        et.begin();

	        // ✅ Step 6: Save to DB
	        em.persist(c);

	        et.commit();

	        resp.getWriter().print("Car Registered Successfully!");

	    } catch (Exception e) {
	        e.printStackTrace();
	        resp.getWriter().print("Error while saving data");
	    } finally {
	        em.close(); // ✅ always close
	    }
	}
}