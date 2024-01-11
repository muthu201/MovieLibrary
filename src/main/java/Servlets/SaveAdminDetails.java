package Servlets;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Dao.Dao;
import Dto.AdminDto;

@WebServlet("/saveAdminInfo")
public class SaveAdminDetails extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("adminId"));
		String name=req.getParameter("adminName");
		long contact=Long.parseLong(req.getParameter("adminContact"));
		String email=req.getParameter("adminEmail");
		String password=req.getParameter("adminPassword");
		
		AdminDto admin=new AdminDto();
		admin.setaId(id);
		admin.setaName(name);
		admin.setaContact(contact);
		admin.setaEmail(email);
		admin.setaPassword(password);
		
		Dao aDao= new Dao();
		try {
			aDao.saveAdmin(admin);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
