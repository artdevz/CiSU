package com.CiSU.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.CiSU.dto.users.RegisterDTO;
import com.CiSU.dto.users.UserRequestDTO;
import com.CiSU.dto.users.UserResponseDTO;
import com.CiSU.models.UserModel;
import com.CiSU.repositories.UserRepository;
import com.CiSU.services.UserService;

import jakarta.validation.Valid;

@SuppressWarnings("rawtypes")
@Controller
public class UserController {
    
    @Autowired
    UserRepository ur;

    @Autowired
    UserService us;

    // CRUD:

    @PostMapping("/user/create")
    public ResponseEntity createNewUser(@RequestBody @Valid RegisterDTO data) {

        if (this.ur.findByUserEmail(data.email()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        UserModel newUser = new UserModel(data.name(), data.email(), encryptedPassword, data.role(), us.randomizeScore());

        this.ur.save(newUser);

        return ResponseEntity.ok().build();

    }

    @PostMapping("/user/read")
    public ResponseEntity readAllUsers() {

        List<UserResponseDTO> userList = this.ur.findAll().stream().map(UserResponseDTO::new).toList();

        return ResponseEntity.ok(userList);

    }

    // @PostMapping("/user/update")
    // public ResponseEntity updateUser(@RequestBody @Valid UserDTO data) {
    //     return ResponseEntity.ok.build();
    // }

    // Skill Issue :(
    @DeleteMapping("/user/delete")
    public ResponseEntity deleteUser(@RequestBody @Valid UserRequestDTO data) {

        ur.deleteById(data.id());

        return ResponseEntity.ok().build();

    }

}
