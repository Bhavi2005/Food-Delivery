package com.foodApp.Dao;

import java.util.List;

import com.foodApp.model.Restaurant;

public interface RestaurantDao {
	
	 int addRestaurant(Restaurant restaurant);
	    Restaurant getRestaurantById(int id);
	    List<Restaurant> getAllRestaurants();
	    int updateRestaurant(Restaurant restaurant);
	    int deleteRestaurant(int id);
}
