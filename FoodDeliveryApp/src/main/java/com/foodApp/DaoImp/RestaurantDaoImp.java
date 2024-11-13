
package com.foodApp.DaoImp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.foodApp.Dao.RestaurantDao;
import com.foodApp.model.Restaurant;

public class RestaurantDaoImp implements RestaurantDao {
    private static final String URL = "jdbc:mysql://localhost:3306/fooddelivery";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private Connection con;

    // SQL Queries
    private static final String INSERT_QUERY = "INSERT INTO restaurant (restaurantId, name, cuisineType, address, ratings, isActive, deliveryTime, image) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String FETCH_ALL_QUERY = "SELECT restaurantId, name, cuisineType, address, ratings, isActive, deliveryTime, image FROM restaurant";
    private static final String FETCH_BY_ID_QUERY = "SELECT * FROM restaurant WHERE restaurantId = ?";
    private static final String UPDATE_QUERY = "UPDATE restaurant SET name = ?, cuisineType = ?, address = ?, ratings = ?, isActive = ?, deliveryTime = ?, image = ? WHERE restaurantId = ?";
    private static final String DELETE_QUERY = "DELETE FROM restaurant WHERE restaurantId = ?";
    String path = "A:\\Images\\user.png";
	File file = new File(path);
	FileInputStream fis;
	private Statement stmt;
	private Restaurant res;
	private ResultSet result;
    public RestaurantDaoImp() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Insert a new restaurant into the database
    @Override
    public int addRestaurant(Restaurant res) {
        int result = 0;
        try  {
        	PreparedStatement pstmt = con.prepareStatement(INSERT_QUERY);
        	
			try {
				fis = new FileInputStream(file);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            pstmt.setInt(1, res.getRestaurantId());
            pstmt.setString(2, res.getName());
            pstmt.setString(3, res.getCuisineType());
            pstmt.setString(4, res.getAddress());
            pstmt.setInt(5, res.getRatings());
            pstmt.setString(6, res.getIsActive());
            pstmt.setInt(7, res.getDeliveryTime());
            
            pstmt.setBinaryStream(8, fis);

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // Get all restaurants from the database
    @Override
    public List<Restaurant> getAllRestaurants() {
        List<Restaurant> restaurants = new ArrayList<>();
        try {
			stmt=con.createStatement();
			result=stmt.executeQuery(FETCH_ALL_QUERY);
			while(result.next()) {
			 res=new Restaurant( result.getInt("restaurantId"),
		                result.getString("name"),
		                result.getString("cuisineType"),
		                result.getString("address"),
		                result.getInt("ratings"),
		                result.getString("isActive"),
		                result.getInt("deliveryTime"),
		                result.getBlob("image"));
			 restaurants.add(res);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return restaurants;
    }
      
        @Override
    public Restaurant getRestaurantById(int id) {
        Restaurant restaurant = null;
        try  {
        	PreparedStatement pstmt = con.prepareStatement(FETCH_BY_ID_QUERY);
            pstmt.setInt(1, id);
             result = pstmt.executeQuery();

                restaurant = new Restaurant(
                		res.getRestaurantId(),
                        res.getName(),
                        res.getCuisineType(),
                        res.getAddress(),
                        res.getRatings(),
                        res.getIsActive(),
                        res.getDeliveryTime(),
                        res.getImage());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return restaurant;
    }

    // Update an existing restaurant
    @Override
    public int updateRestaurant(Restaurant restaurant) {
        int result = 0;
        try  {
        	PreparedStatement pstmt = con.prepareStatement(UPDATE_QUERY);
            pstmt.setString(1, restaurant.getName());
            pstmt.setString(2, restaurant.getCuisineType());
            pstmt.setString(3, restaurant.getAddress());
            pstmt.setDouble(4, restaurant.getRatings());
            pstmt.setString(5, restaurant.getIsActive());
            pstmt.setInt(6, restaurant.getDeliveryTime());
            pstmt.setBinaryStream(7,fis);
           

            pstmt.setInt(8, restaurant.getRestaurantId());
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // Delete a restaurant by its ID
    @Override
    public int deleteRestaurant(int id) {
        int result = 0;
        try  {
        	PreparedStatement pstmt = con.prepareStatement(DELETE_QUERY);
            pstmt.setInt(1, id);
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

   

}
