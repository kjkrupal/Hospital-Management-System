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
			<h1>Administrator</h1>
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
				<form>
				<input type="hidden" name="action">
				<h3>Create User</h3>
				<ul>
					<li><a href="<%=request.getContextPath()%>/Admin?action=add-user">Add User</a></li>
					<li><a href="<%=request.getContextPath()%>/Admin?action=add-doctor">Add Doctor</a></li>
				</ul><br><br>
				<h3>Manage User</h3>
				<ul>
					<li><a href="<%=request.getContextPath()%>/Admin?action=edit-user">Edit user details</a></li>
					<li><a href="<%=request.getContextPath()%>/Admin?action=edit-doctor">Edit doctor details</a></li>
				</ul>
				</form>
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