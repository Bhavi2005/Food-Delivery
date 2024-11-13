package com.foodApp.DaoImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import com.foodApp.Dao.UserDao;
import com.foodApp.model.User;
import com.secret.Decrypt;
import com.secret.Encrypt;

public class UserDaoImp implements UserDao {

    private static String url = "jdbc:mysql://localhost:3306/fooddelivery";
    private static Connection con;
    private static String username = "root";
    private static String password = "root";

    private static final String INSERT_QUERY = "INSERT INTO user(username, email, password, mobile, role, address) VALUES(?, ?, ?, ?, ?, ?)";
    private static final String FETCH_ALL = "SELECT * FROM user";
    private static final String GET_USER = "SELECT * FROM user WHERE email = ?";
    private static final String DELETE_USER = "DELETE FROM user WHERE email = ?";
    private static final String UPDATE_LOGIN_TIME = "UPDATE user SET last_login = ? WHERE email = ?";
    
    private PreparedStatement pstmt;
    private ResultSet resultSet;
    private Statement stmt;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getUser(String email) {
        User user = null;
        try {
            pstmt = con.prepareStatement(GET_USER);
            pstmt.setString(1, email);
            resultSet = pstmt.executeQuery();
            
            if (resultSet.next()) {
                user = new User(
                    resultSet.getString("username"),
                    resultSet.getString("email"),
                    resultSet.getString("password"),
                    resultSet.getLong("mobile"),
                    resultSet.getString("role"),
                    resultSet.getString("address")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return user;
    }

    @Override
    public void addUser(User u) {
        try {
            pstmt = con.prepareStatement(INSERT_QUERY);
            pstmt.setString(1,Encrypt.encrypt(u.getUsername()));
            pstmt.setString(2,Encrypt.encrypt( u.getEmail()));
            pstmt.setString(3,Encrypt.encrypt(u.getPassword()));
            pstmt.setLong(4, u.getMobile());
            pstmt.setString(5, u.getRole());
            pstmt.setString(6, u.getAddress());
            int result = pstmt.executeUpdate();
            System.out.println(result != 0 ? "User added successfully" : "Failed to add user");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
    }

    @Override
    public void fetchAll() {
        try {
            stmt = con.createStatement();
            resultSet = stmt.executeQuery(FETCH_ALL);
            while (resultSet.next()) {
                System.out.println(
                    resultSet.getInt("uid") + " " +
                    		Decrypt.decrypt(resultSet.getString("username")) + " " +
                    		Decrypt.decrypt(resultSet.getString("email")) + " " +
                    				Decrypt.decrypt(resultSet.getString("password")) + " " +
                    resultSet.getLong("mobile") + " " +
                    resultSet.getString("address") + " " +
                    resultSet.getTimestamp("account_created") + " " +
                    resultSet.getTimestamp("last_login")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
    }

    @Override
    public void updateUser() {
        // Implementation for updating user details
    }

    @Override
    public void deleteUser(String email) {
        try {
            pstmt = con.prepareStatement(DELETE_USER);
            pstmt.setString(1, email);
            int result = pstmt.executeUpdate();
            System.out.println(result != 0 ? "User deleted successfully" : "User not found");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
    }

    // Method to update the login time of the user
    public void updateLoginTime(String email, Timestamp loginTime) {
        try {
            pstmt = con.prepareStatement(UPDATE_LOGIN_TIME);
            pstmt.setTimestamp(1, loginTime);
            pstmt.setString(2, email);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
    }

    // Helper method to close resources
    private void closeResources() {
        try {
            if (resultSet != null) resultSet.close();
            if (pstmt != null) pstmt.close();
            if (stmt != null) stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
