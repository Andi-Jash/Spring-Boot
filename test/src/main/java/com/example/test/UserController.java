package com.example.test; // Package declaration

import org.springframework.web.bind.annotation.*; // Import Spring MVC annotations
import java.util.ArrayList; // Import ArrayList
import java.util.List; // Import List

// Annotate the class as a REST controller
@RestController
public class UserController {
    // Declare a private List to hold User objects in memory
    private List<User> users = new ArrayList<>();

    // Handle POST requests to the "/users" endpoint
    @PostMapping("/users")
    public List<User> addUsers(@RequestBody List<User> users) {
        // Add all User objects from the request body to the in-memory list
        this.users.addAll(users);
        // Return the added User objects in the response
        return users;
    }

    // Handle GET requests to the "/users" endpoint
    @GetMapping("/users")
    public String getAllUsers() {
        // Initialize a StringBuilder to construct the HTML response
        StringBuilder response = new StringBuilder("<html><body>");

        // Iterate through each User object in the users list
        for (User user : users) {
            // Append the user's name and email to the response as a paragraph
            response.append("<p>Name: ")
                    .append(user.getName()) // Get the user's name
                    .append(", Email: ")
                    .append(user.getEmail())
                    .append(", School: ")
                    .append(user.getSchool())
                    .append("</p>"); // Close the paragraph tag
        }

        // Append closing HTML tags to the response
        response.append("</body></html>");
        // Return the constructed HTML string
        return response.toString();
    }
}
