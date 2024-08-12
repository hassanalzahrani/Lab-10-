package com.example.job_seeking_system.Controller;

import com.example.job_seeking_system.ApiResponse.ApiRsponsee;
import com.example.job_seeking_system.Model.User;
import com.example.job_seeking_system.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;
@GetMapping("/get")
    public ResponseEntity getUsers(){
        return ResponseEntity.status(200).body(userService.getAllUsers());
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@Valid @RequestBody User user, Errors errors){
    if(errors.hasErrors()){
        String message = errors.getFieldError().getDefaultMessage();
        return ResponseEntity.status(400).body(message);
    }
    userService.addUser(user);
   return ResponseEntity.status(200).body(new ApiRsponsee("user added successfully"));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id, @Valid @RequestBody User user, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated = userService.updateUser(id, user);
        if(isUpdated){
            return ResponseEntity.status(200).body(new ApiRsponsee("user updated successfully"));
        }
        return ResponseEntity.status(404).body(new ApiRsponsee("user not found"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity getUserById(@PathVariable Integer id){
    boolean isDeleted = userService.deleteUser(id);
    if(isDeleted){
        return ResponseEntity.status(200).body(new ApiRsponsee("user deleted successfully"));
    }
    return ResponseEntity.status(404).body(new ApiRsponsee("user not found"));
    }
}
