<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List, carrentalsystem.Car" %>
<%
    // Get the list of available cars from the servlet
    List<Car> carlist = (List<Car>) request.getAttribute("carlist");
%>
<html>
<head>
    <title>Available Cars</title>
    <style>
        body { font-family: Arial; background: #f4f4f9; color: #333; margin: 20px; }
        h2 { text-align: center; margin-bottom: 20px; }
        table { width: 100%; border-collapse: collapse; margin-bottom: 20px; }
        th, td { padding: 10px; border: 1px solid #ccc; text-align: left; }
        th { background-color: #007BFF; color: white; }
        form input[type=text], form input[type=date] { padding:5px; margin-bottom:5px; border-radius:4px; border:1px solid #ccc; }
        form input[type=submit] { background-color: #007BFF; color: white; padding:5px; border:none; border-radius:4px; cursor:pointer; }
        form input[type=submit]:hover { background-color: #0056b3; }
        a { text-decoration:none; color:#007BFF; margin-right:10px; }
        a:hover { text-decoration: underline; }
    </style>
    <script>
        // Simple client-side validation for booking
        function validateBooking(form){
            let uname=form.uname.value.trim();
            let sdate=form.sdate.value;
            let edate=form.edate.value;
            if(!uname || !sdate || !edate){ 
                alert("All fields are required!"); 
                return false; 
            }
            if(new Date(sdate) > new Date(edate)){ 
                alert("Start date cannot be after end date"); 
                return false; 
            }
            return true;
        }
    </script>
</head>
<body>
<h2>Available Cars</h2>
<div style="overflow-x:auto;">
<table>
    <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Model</th>
            <th>Number</th>
            <th>Owner</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
    <%
        if(carlist != null && !carlist.isEmpty()){
            for(Car car : carlist){
    %>
        <tr>
            <td><%=car.getRegCarId()%></td>
            <td><%=car.getRegCarName()%></td>
            <td><%=car.getRegCarModel()%></td>
            <td><%=car.getRegCarNumber()%></td>
            <td><%=car.getOwnerName()%></td>
            <td>
                <!-- Booking form: posts to Bookcar servlet -->
                <form action="bookcar" method="post" onsubmit="return validateBooking(this)">
                    <input type="hidden" name="carid" value="<%=car.getRegCarId()%>"/>
                    Name: <input type="text" name="uname" placeholder="Your Name" required/>
                    Start Date: <input type="date" name="sdate" required/>
                    End Date: <input type="date" name="edate" required/>
                    <input type="submit" value="Book"/>
                </form>
            </td>
        </tr>
    <%
            }
        } else {
    %>
        <tr>
            <td colspan="6" style="text-align:center;">No cars available</td>
        </tr>
    <%
        }
    %>
    </tbody>
</table>
</div>

<div style="text-align:center;">
    <!-- Main navigation -->
    <a href="registercar.jsp">Register New Car</a> |
    <a href="listofbooking">View Bookings</a>
</div>
</body>
</html>
