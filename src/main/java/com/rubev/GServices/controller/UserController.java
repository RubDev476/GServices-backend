package com.rubev.GServices.controller;

import com.rubev.GServices.dto.UserRegisterDTO;
import com.rubev.GServices.model.User;
import com.rubev.GServices.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/users")
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> registerUser(@RequestBody UserRegisterDTO user) {
        userService.register(user);

        return ResponseEntity.ok("User register successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);

        return ResponseEntity.ok("User deleted successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody UserRegisterDTO user) {
        boolean updated = userService.updateUser(id, user);

        if(updated) return ResponseEntity.ok("User updated successfully");

        return ResponseEntity.notFound().build();
    }
}
