package carrentalsystem;

import java.io.IOException;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bookcar")
public class Bookcar extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int carid = 0;

        // ✅ Step 1: Handle number safely
        try {
            carid = Integer.parseInt(req.getParameter("carid"));
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().print("Invalid Car ID");
            return;
        }

        String username = req.getParameter("uname");
        String sdate = req.getParameter("sdate");
        String edate = req.getParameter("edate");

        // ✅ Step 2: Date validation (IMPORTANT)
        LocalDate startDate = null;
        LocalDate endDate = null;
        LocalDate today = LocalDate.now();

        try {
            startDate = LocalDate.parse(sdate);
            endDate = LocalDate.parse(edate);
        } catch (Exception e) {
            resp.getWriter().print("Invalid date format");
            return;
        }

        // ❌ past date check
        if (startDate.isBefore(today)) {
            resp.getWriter().print("Start date cannot be in the past!");
            return;
        }

        // ❌ same date check
        if (endDate.isEqual(startDate)) {
            resp.getWriter().print("Start date and End date cannot be same!");
            return;
        }

        // ❌ end date before start date
        if (endDate.isBefore(startDate)) {
            resp.getWriter().print("End date must be after start date!");
            return;
        }
        
        
        
        
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();

        // ✅ Step 3: Find car
        Car car = em.find(Car.class, carid);

        if (car == null) {
            resp.getWriter().print("Car not found!");
            em.close();
            return;
        }

        // ❌ already booked
        if (car.getStatus().equals(Constants.BOOKED)) {
            resp.getWriter().print("Car already booked!");
            em.close();
            return;
        }

        // ✅ Step 4: Create booking
        Booking booking = new Booking(carid, username, sdate, edate);

        et.begin();

        em.persist(booking);

        // update car status
        car.setStatus(Constants.BOOKED);

        et.commit();

        resp.sendRedirect("listofbooking");

        em.close();
    }
}