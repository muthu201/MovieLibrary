package Servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.Dao;
import Dto.MovieDto;
@WebServlet("/editOne")
public class EditMovie extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("movieId"));
		Dao mDao=new Dao();
		try {
			HttpSession session=req.getSession();
			String adminName=(String) session.getAttribute("adminEmail");
			if(adminName != null) {
			MovieDto movie=mDao.findByMovieId(id);
			req.setAttribute("movie",movie);
			RequestDispatcher rd=req.getRequestDispatcher("EditMovie.jsp");
			rd.include(req, resp);
			}
			else {
				req.setAttribute("message", "access denied, admin login is required");
				RequestDispatcher rd=req.getRequestDispatcher("AdminSignIn.jsp");
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
