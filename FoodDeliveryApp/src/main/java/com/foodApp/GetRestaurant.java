package com.foodApp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodApp.Dao.RestaurantDao;
import com.foodApp.DaoImp.RestaurantDaoImp;
import com.foodApp.model.Restaurant;

@WebServlet("/GetRestaurant")
public class GetRestaurant extends HttpServlet {
    private RestaurantDao restaurantDao;
    private RestaurantDao restaurantDaoImp;
    String path="C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\user.png"; // Image path
    File file = new File(path); // Image file

    @Override
    public void init() {
        restaurantDao = new RestaurantDaoImp();  // Initialize the DAO for getting all restaurants
        restaurantDaoImp = new RestaurantDaoImp();  // Initialize the DAO for adding a new restaurant
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    	
        List<Restaurant> restaurantList = restaurantDao.getAllRestaurants();

         req.setAttribute("restaurantList", restaurantList);

       req.getRequestDispatcher("/RestaurantList.jsp").forward(req, resp);
    }
}
