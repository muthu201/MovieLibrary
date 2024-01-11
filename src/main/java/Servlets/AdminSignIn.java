package Servlets;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Dao.Dao;
import Dto.AdminDto;

@WebServlet("/adminSignIn")
public class AdminSignIn extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String adminEmail=req.getParameter("adminEmail");
		String adminPassword=req.getParameter("adminPassword");
		
		Dao aDao=new Dao();
		try {
			AdminDto admin=aDao.findByEmail(adminEmail);
			if(admin != null) {
				if(admin.getaPassword().equals(adminPassword)) {
					Dao mDao=new Dao();
					req.setAttribute("movies",mDao.getAllMovies() );
					RequestDispatcher rd=req.getRequestDispatcher("AdminHome.jsp");
					rd.include(req, resp);
				}
				else {
					req.setAttribute("message", "Password is wrong");
					RequestDispatcher rd=req.getRequestDispatcher("AdminSignIn.jsp");
					rd.include(req, resp);
				}
			}
			else {
				req.setAttribute("message", "Email is wrong");
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
