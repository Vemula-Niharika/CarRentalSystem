# 🚗 Car Rental Management System

A web-based Car Rental System developed using Java Servlets and JSP to manage vehicle availability and customer bookings.

## 🔧 Technologies
Java, Servlets, JSP, Hibernate (JPA), PostgreSQL, Apache Tomcat

## 📌 Features
- Car registration (Admin)
- View available cars
- Book cars with date validation
- Cancel bookings
- View booking details
- Real-time car status (Available / Booked)

## 🏗️ Architecture
Follows MVC (Model-View-Controller):
- Model: Hibernate entities (Car, Booking)
- View: JSP pages
- Controller: Servlets

## ⚙️ Modules
- Car Registration  
- Available Cars  
- Booking  
- Cancel Booking  
- Booking List  

## 🧠 Key Highlights
- Implemented booking workflow with status-based logic
- Added validation for dates and inputs
- Prevented duplicate car entries
- Ensured data consistency between booking and car availability

## 🗄️ Database
- PostgreSQL used for data storage  
- Hibernate (JPA) for ORM and CRUD operations  

## ▶️ How to Run
1. Clone the repository  
2. Configure PostgreSQL (create database: `carrental`)  
3. Update DB credentials in `persistence.xml`  
4. Deploy on Apache Tomcat server  
5. Run: `http://localhost:8080/carrental`

## 🚀 Future Enhancements
- Add authentication (Admin/User)
- Improve UI
- Add booking conflict handling
