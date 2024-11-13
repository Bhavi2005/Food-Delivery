package com.foodApp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodApp.DaoImp.UserDaoImp;
import com.foodApp.model.User;


@WebServlet("/Signup")
public class Signup extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDaoImp ud=new UserDaoImp();
		String username=req.getParameter("username");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		long mobile=Long.parseLong(req.getParameter("mobile"));
		String role=req.getParameter("role");
		String address=req.getParameter("address");
		User u=new User(username,email,password,mobile,role,address);
		ud.addUser(u);
		resp.sendRedirect("Login.jsp");

	}
       
   
}
