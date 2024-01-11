<%@page import="java.util.Base64"%>
<%@page import="Dto.MovieDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Welcome Admin</h2>
	<%List<MovieDto> movies=(List)request.getAttribute("movies"); %>
	<table border="4px">
	
	<tr>
	<th>movieId</th>
	<th>movieName</th>
	<th>moviePrice</th>
	<th>movieRating</th>
	<th>movieGenre</th>
	<th>movieLanguage</th>
	<th>movieImage</th>
	<th>Delete</th>
	<th>Edit</th>
	
	</tr>
	<%for(MovieDto m:movies){ %>
	<tr>
	<td><%=m.getmId() %></td>
	<td><%=m.getmName() %></td>
	<td><%=m.getmPrice() %></td>
	<td><%=m.getmRating() %></td>
	<td><%=m.getmGenre() %></td>
	<td><%=m.getmLanguage() %></td>
 	<% String base64image=new String(Base64.getEncoder().encode(m.getMovieImage())) ;%>	
 	<td><img  src="data:image/jpeg;base64, <%=base64image %>" height="100px" width="100px"></td>
 	<td><a href="deleteOne?id=<%= m.getmId() %>" >Delete</a></td>
 	<td><a href="editOne?movieId=<%= m.getmId() %>" >Edit</a></td>
	</tr>
	<%} %>
	</table>
	
	<a href="AddMovie.jsp">AddMovie</a>
</body>
</html>