<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Car Rental Dashboard</title>
    <style>
        body { font-family: Arial; text-align: center; margin-top: 50px; }
        h1 { color: #007BFF; }
        .menu { margin-top: 30px; }
        a.button {
            display: inline-block;
            margin: 10px;
            padding: 15px 30px;
            background-color: #007BFF;
            color: white;
            border-radius: 8px;
            text-decoration: none;
            font-weight: bold;
        }
        a.button:hover { background-color: #0056b3; }
    </style>
</head>
<body>
    <h1>Car Rental Dashboard</h1>
    <div class="menu">
        <a class="button" href="registercar.jsp">Register a Car</a>
        <a class="button" href="availablecars">Available Cars</a>
        <a class="button" href="listofbooking">List of Booking</a>
    </div>
</body>
</html>
