package com.example.job_seeking_system.Service;

import com.example.job_seeking_system.Model.User;
import com.example.job_seeking_system.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    public void addUser(User user) {
        userRepository.save(user);
    }

    public boolean updateUser(Integer id,User user) {
        User u = userRepository.findById(id).get();
        if (u == null) {
            return false;
        }
        u.setName(user.getName());
        u.setEmail(user.getEmail());
        u.setAge(user.getAge());
        u.setRole(user.getRole());
        u.setPassword(user.getPassword());
        userRepository.save(u);
        return true;

    }
    public boolean deleteUser(Integer id) {
        User u = userRepository.findById(id).get();
        if (u == null) {
            return false;

        }
        userRepository.delete(u);
        return true;
    }


    }



