package com.foodApp.model;

import java.io.FileInputStream;
import java.sql.Blob;

public class Restaurant {
	private int restaurantId;
	private String name;
	private String cuisineType;
	private String address;
	private int ratings;
	private String isActive;
	private int deliveryTime;
	private Blob image;
	
    // Other attributes, constructors, getters, and setters

   
	public Restaurant() {
		super();
	}
	public Restaurant(int restaurantId,String name, String cuisineType, String address, int ratings, String isActive,
			int deliveryTime, Blob image) {
		super();
		this.name = name;
		this.cuisineType = cuisineType;
		this.address = address;
		this.ratings = ratings;
		this.isActive = isActive;
		this.deliveryTime = deliveryTime;
		this.image = image;
		this.restaurantId = restaurantId;
	}
	
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCuisineType() {
		return cuisineType;
	}
	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getRatings() {
		return ratings;
	}
	public void setRatings(int ratings) {
		this.ratings = ratings;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public int getDeliveryTime() {
		return deliveryTime;
	}
	public void setDeliveryTime(int deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	public Blob getImage() {
		return image;
	}
	public void setImage(Blob image) {
		this.image = image;
	}
	
}
