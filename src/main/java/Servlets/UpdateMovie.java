package Servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import Dao.Dao;
import Dto.MovieDto;
@WebServlet("/updateMovie")
@MultipartConfig(maxFileSize = 5*1024*1024)
public class UpdateMovie extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int mId=Integer.parseInt(req.getParameter("movieId"));
		String mName=req.getParameter("movieName");
		double mPrice=Double.parseDouble(req.getParameter("moviePrice"));
		double mRating=Double.parseDouble(req.getParameter("movieRating"));
		String mGenre=req.getParameter("movieGenre");
		String mLanguage=req.getParameter("movieLanguage");
		Part moviePart=req.getPart("movieImage");
		
		MovieDto movie=new MovieDto();
		movie.setmId(mId);
		movie.setmName(mName);
		movie.setmPrice(mPrice);
		movie.setmRating(mRating);
		movie.setmGenre(mGenre);
		movie.setmLanguage(mLanguage);
		
		Dao mDao=new Dao() ;
		try {
			if(moviePart.getSize()>0) {
			movie.setMovieImage(moviePart.getInputStream().readAllBytes());
			mDao.updateMovie(movie);
			
			req.setAttribute("movies", mDao.getAllMovies());
			RequestDispatcher rd=req.getRequestDispatcher("AdminHome.jsp");
			rd.include(req, resp);
			}
			else {
				MovieDto dbMovie=mDao.findByMovieId(mId);
				movie.setMovieImage(dbMovie.getMovieImage());
				mDao.updateMovie(movie);
				
				req.setAttribute("movies", mDao.getAllMovies());
				RequestDispatcher rd=req.getRequestDispatcher("AdminHome.jsp");
				rd.include(req, resp);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
