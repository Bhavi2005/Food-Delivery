<%@ page import="java.util.List" %>
<%@ page import="com.foodApp.model.Restaurant" %>
<%@ page import="java.util.Base64" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Restaurant List</title>
    <link rel="icon"href="restaurant.png">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 20px;
        }
        h1 {
            text-align: center;
            color: #333;
        }
        .restaurant-container {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-evenly;
        }
        .restaurant-card {
            border: 1px solid #ccc;
            border-radius: 8px;
            padding: 20px;
            margin: 15px;
            width: 250px;
            background-color: white;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            transition: transform 0.3s ease;
        }
        .restaurant-card:hover {
            transform: scale(1.05);
        }
        .restaurant-card img {
            width: 100%;
            height: auto;
            border-radius: 4px;
        }
        .restaurant-card h3 {
            font-size: 1.2em;
            color: #333;
            margin-bottom: 10px;
        }
        .restaurant-card p {
            color: #666;
            margin: 5px 0;
        }
        /* Rating star styling */
        .star-rating {
            display: flex;
            justify-content: flex-start;
            margin-top: 5px;
        }
        .star-rating .star {
            color: #f39c12; /* Gold color for filled stars */
            font-size: 20px;
            margin-right: 3px;
        }
        .star-rating .star.empty {
            color: #ddd; /* Light gray for empty stars */
        }
       
    </style>
</head>
<body>
    <h1>List of Restaurants</h1>

    <% 
        // Retrieve the restaurant list from the request attribute
        List<Restaurant> restaurantList = (List<Restaurant>) request.getAttribute("restaurantList");

        if (restaurantList != null && !restaurantList.isEmpty()) {
    %>
    <div class="restaurant-container">
        <% for (Restaurant res : restaurantList) { 
            int rating = res.getRatings(); // Assume ratings are an integer (1-5)
            byte[] imageBytes = res.getImage() != null ? res.getImage().getBytes(1, (int) res.getImage().length()) : null; // Retrieve image bytes from Blob
            String base64Image = imageBytes != null ? Base64.getEncoder().encodeToString(imageBytes) : null;
        %>
            <div class="restaurant-card">
                <h2 style="color:violet"><%= res.getName() %></h3>
                
                <% if (base64Image != null) { %>
                    <img src="data:image/jpeg;base64,<%= base64Image %>" alt="Restaurant Image">
                <% } else { %>
                    <p>No image available</p>
                <% } %>

                <p><strong>Cuisine Type:</strong> <%= res.getCuisineType() %></p>
                <p><strong>Address:</strong> <%= res.getAddress() %></p>

                <!-- Star Rating -->
                <p><strong>Rating:</strong>
                    <div class="star-rating">
                        <% for (int i = 1; i <= 5; i++) { %>
                            <span class="star <%= i <= rating ? "" : "empty" %>">&#9733;</span>
                        <% } %>
                    </div>
                </p>
                
                <p><strong>Status:</strong> <%= res.getIsActive() %></p>
                <p><strong>Delivery Time:</strong> <%= res.getDeliveryTime() %> minutes</p>
            </div>
        <% } %>
    </div>
    <% 
        } else {
            out.println("<p>No restaurants available.</p>");
        }
    %>
</body>
</html>
