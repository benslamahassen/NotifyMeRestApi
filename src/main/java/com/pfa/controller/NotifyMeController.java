package com.pfa.controller;

import com.pfa.repositories.*;
import com.pfa.model.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;

@RestController
@RequestMapping("/")
@CrossOrigin("*")

public class NotifyMeController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        Sort sortByFirstNameDesc = new Sort(Sort.Direction.DESC, "firstName");
        return userRepository.findAll(sortByFirstNameDesc);
    }
    @PostMapping("/users")
    public User createUser(User user) {
        return userRepository.save(user);
    }
}
