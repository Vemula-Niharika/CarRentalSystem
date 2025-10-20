<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List, carrentalsystem.Booking" %>
<%
    // Get the list of bookings from the servlet
    List<Booking> bookinglist = (List<Booking>) request.getAttribute("bookinglist");
%>
<html>
<head>
    <title>All Bookings</title>
    <style>
        body { font-family: Arial; background: #f4f4f9; color: #333; margin: 20px; }
        h2 { text-align: center; margin-bottom: 20px; }
        table { width: 100%; border-collapse: collapse; margin-bottom: 20px; }
        th, td { padding: 10px; border: 1px solid #ccc; text-align: left; }
        th { background-color: #007BFF; color: white; }
        a { text-decoration:none; color:#007BFF; }
        a:hover { text-decoration: underline; }
    </style>
</head>
<body>
<h2>All Bookings</h2>
<div style="overflow-x:auto;">
<table>
    <thead>
        <tr>
            <th>Booking ID</th>
            <th>Car ID</th>
            <th>User</th>
            <th>Start Date</th>
            <th>End Date</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
    <%
        if(bookinglist != null && !bookinglist.isEmpty()){
            for(Booking b : bookinglist){
    %>
        <tr>
            <td><%=b.getBid()%></td>
            <td><%=b.getCid()%></td>
            <td><%=b.getUname()%></td>
            <td><%=b.getSdate()%></td>
            <td><%=b.getEdate()%></td>
            <td>
                <!-- Delete link: admin can delete the booking -->
                <a href="changestatus?bid=<%=b.getBid()%>&cid=<%=b.getCid()%>">Cancel Booking</a>
            </td>
        </tr>
    <%
            }
        } else {
    %>
        <tr>
            <td colspan="6" style="text-align:center;">No bookings found</td>
        </tr>
    <%
        }
    %>
    </tbody>
</table>
</div>
</body>
</html>
