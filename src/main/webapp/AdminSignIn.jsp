<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style >

</style>
</head>
<body>
            <h2>Admin Login</h2>
         <form action="adminSignIn" method="post">
 		 <label for="email">Email</label>
         <input type="email" id="email" name="adminEmail">
		 <label for="password">Password</label>
		 <input type="password" id="password" name="adminPassword" >
		 <input type="submit">
		 </form>
		 <% String message=(String)request.getAttribute("message"); %>
		 <%if(message != null){ %>
		 <%=message %>
		 <%} %>
</body>
</html>