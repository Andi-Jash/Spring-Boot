package com.example.test;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private List<User> users = new ArrayList<>();

    @PostMapping
    public ResponseEntity<String> addUsers(@RequestBody List<User> users) {
        if (users == null || users.isEmpty()) {
            return new ResponseEntity<>("No users provided", HttpStatus.BAD_REQUEST);
        }
        this.users.addAll(users);
        return new ResponseEntity<>("Users added successfully", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<String> getAllUsers() {
        StringBuilder response = new StringBuilder("<html><body>");

        for (User user : users) {
            response.append("<p>Name: ")
                    .append(user.getName())
                    .append(", Email: ")
                    .append(user.getEmail())
                    .append(", School: ")
                    .append(user.getSchool())
                    .append("</p>");
        }

        response.append("</body></html>");
        return new ResponseEntity<>(response.toString(), HttpStatus.OK);
    }
}
