package com.foodApp.Dao;

import com.foodApp.model.User;

public interface UserDao {
	void addUser(User u);

	void fetchAll();

	void updateUser();

	void deleteUser(String email);

	User getUser(String email);
}
