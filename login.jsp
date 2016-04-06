<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Login</title>
	<link rel="stylesheet" type="text/css" href="style1.css">		
	
</head>
	
<body>		

	<header id="header">
		<div class="innertube">
			<h1 align="center">Login</h1>
		</div>
	</header>
		
	<div id="wrapper">
		
		<main>
			<div id="content">
				<div class="innertube">
					<form method="post" action="<%=request.getContextPath()%>/Admin">
						
						<table align="center">
						<tr><td><h3>E-mail:</h3></td><td><h3><input type="text" name="username" value=""></h3></td></tr>
						<tr><td><h3>Password:</h3></td><td><h3><input type="password" name="password" value=""></h3></td></tr>
						</table>
						<p align="center"><input type="submit" name="submit" value="Login" /></p>
					</form>
					<p></p>
				</div>
			</div>
		</main>
		
	</div>
		
	<footer id="footer">
		<div class="innertube">
			<p>Footer</p>
		</div>
	</footer>
	
</body>
</html>