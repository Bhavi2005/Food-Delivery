package com.foodApp.model;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodApp.Dao.RestaurantDao;
import com.foodApp.DaoImp.RestaurantDaoImp;
import com.foodApp.DaoImp.UserDaoImp;
import com.foodApp.model.User;
import com.secret.Encrypt;

@WebServlet("/Login")
public class Login extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		String email =Encrypt.encrypt(req.getParameter("email"));
		String password = Encrypt.encrypt(req.getParameter("password"));

		
		UserDaoImp ud = new UserDaoImp();
		User u=ud.getUser(email);

		if (u != null && password.equals(u.getPassword())) {
			Timestamp loginTime = Timestamp.from(Instant.now()); // Successful login: log the current time
			ud.updateLoginTime(u.getEmail(), loginTime);
			resp.sendRedirect("GetRestaurant"); // Redirect to success page (for example: "Success.html")
		} else {
			resp.sendRedirect("Failure.html");  // Failed login: redirect to failure page
		}
		
		
	
	}
}
