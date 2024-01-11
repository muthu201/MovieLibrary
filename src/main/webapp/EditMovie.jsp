<%@page import="java.util.Base64"%>
<%@page import="Dto.MovieDto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% MovieDto movie=(MovieDto)request.getAttribute("movie"); %>
<form action="updateMovie" method="post" enctype="multipart/form-data">
	
	  		 <label for="movieId">Movie ID:</label>
            <input type="text" id="movieId" name="movieId"  value="<%=movie.getmId() %>" readonly ><br>
            
             <label for="movieName">Movie Name:</label>
            <input type="text" id="movieName" name="movieName"  value="<%=movie.getmName() %>"><br>
            
             <label for="moviePrice">Movie Price:</label>
            <input type="text" id="moviePrice" name="moviePrice"  value="<%=movie.getmPrice() %>"> <br>
            
            <label for="movieRating">Movie Rating:</label>
            <input type="text" id="movieRating" name="movieRating"  value="<%=movie.getmRating() %>"><br>
            
             <label for="movieGenre">Movie Genre:</label>
            <input type="text" id="movieGenre" name="movieGenre"  value="<%=movie.getmGenre() %>"><br>
            
             <label for="movieLanguage">Movie Language:</label>
            <input type="text" id="movieLanguage" name="movieLanguage"  value="<%=movie.getmLanguage() %>"> <br>
            
            <label for="movieImage">Movie Image:</label>
            <input type="file" id="movieImage" name="movieImage" ><br>
            
            <input type="submit">
             <% String base64image=new String(Base64.getEncoder().encode(movie.getMovieImage())) ;%>	
 			<img  src="data:image/jpeg;base64, <%=base64image %>" height="100px" width="100px">
	</form>
	
</body>
</html>