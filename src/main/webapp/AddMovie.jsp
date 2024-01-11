<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Add Movie</h2>
	<form action="saveMovie" method="post" enctype="multipart/form-data">
	
	  		 <label for="movieId">Movie ID:</label>
            <input type="text" id="movieId" name="movieId" required><br>
            
             <label for="movieName">Movie Name:</label>
            <input type="text" id="movieName" name="movieName" required><br>
            
             <label for="moviePrice">Movie Price:</label>
            <input type="text" id="moviePrice" name="moviePrice" required> <br>
            
            <label for="movieRating">Movie Rating:</label>
            <input type="text" id="movieRating" name="movieRating" required><br>
            
             <label for="movieGenre">Movie Genre:</label>
            <input type="text" id="movieGenre" name="movieGenre" required><br>
            
             <label for="movieLanguage">Movie Language:</label>
            <input type="text" id="movieLanguage" name="movieLanguage" required> <br>
            
            <label for="movieImage">Movie Image:</label>
            <input type="file" id="movieImage" name="movieImage" ><br>
            
            <input type="submit">
	</form>
	
</body>
</html>