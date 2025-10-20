<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Register Car</title>
    <style>
        body { font-family: Arial; margin: 20px; }
        h2 { text-align: center; }
        form { max-width: 500px; margin: auto; background: #fff; padding: 20px; border-radius: 8px; box-shadow: 0 0 10px rgba(0,0,0,0.1); }
        input[type=text], input[type=number] { width: 100%; padding: 8px; margin-bottom: 10px; border:1px solid #ccc; border-radius: 4px; }
        input[type=submit] { background-color: #007BFF; color: white; padding:10px 20px; border:none; border-radius: 4px; cursor:pointer; }
        input[type=submit]:hover { background-color: #0056b3; }
        .links { text-align:center; margin-top:20px; }
        .links a { margin: 0 10px; color: #007BFF; text-decoration:none; }
        .links a:hover { text-decoration:underline; }
    </style>
</head>
<body>
<h2>Register a New Car</h2>
<form action="registration" method="post">
    Car ID: <input type="number" name="regCarId" required/>
    Car Name: <input type="text" name="regCarName" required/>
    Car Model: <input type="text" name="regCarModel" required/>
    Car Number: <input type="number" name="regCarNumber" required/>
    Owner Name: <input type="text" name="regOwnerName" required/>
    <input type="submit" value="Register Car"/>
</form>
<div class="links">
    <a href="availablecars">View Available Cars</a>
    <a href="listofbooking">View Bookings</a>
    <a href="index.jsp">Back to Dashboard</a>
</div>
</body>
</html>
