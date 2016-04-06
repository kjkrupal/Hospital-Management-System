<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>2 Column Layout &mdash; Left Menu with Header &amp; Footer</title>
	<link rel="stylesheet" type="text/css" href="style.css">		
	
</head>
	
<body>		

	<header id="header">
		<div class="innertube">
			<h1>Receptionist</h1>
		</div>
	</header>
		
	<div id="wrapper">
		
		<main>
			<div id="content">
				<div class="innertube">
					<h1>Home</h1>
					<img src="pic.jpg">
					<p></p>
				</div>
			</div>
		</main>
			
		<nav id="nav">
			<div class="innertube">
				<h3>Menu</h3>
				<ul>
					<li><a href="home.jsp">Home</a></li>
					<li><a href="patient-register.jsp">Patient Register</a></li>
					<li><a href="view-appointment.jsp">View Appointment</a></li>
				</ul>
			</div>
		</nav>
		
	</div>
		
	<footer id="footer">
		<div class="innertube">
			<p>Footer</p>
		</div>
	</footer>
	
</body>
</html>