package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    @GetMapping("/calculate/{num1}/{operator}/{num2}")
    public String calculate(@PathVariable int num1, 
                            @PathVariable String operator, 
                            @PathVariable int num2) {
        int result;
        switch (operator) {
            case "+":
                result = num1 + num2;
                return String.format("The sum of %d and %d is %d.", num1, num2, result);
            case "-":
                result = num1 - num2;
                return String.format("The difference of %d and %d is %d.", num1, num2, result);
            default:
                return "Invalid operator!";
        }
    }
}