package com.CaniNUS.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.CaniNUS.dto.users.RegisterDTO;
import com.CaniNUS.dto.users.UserRequestDTO;
import com.CaniNUS.dto.users.UserResponseDTO;
import com.CaniNUS.models.UserModel;
import com.CaniNUS.repositories.UserRepository;

import jakarta.validation.Valid;

@SuppressWarnings("rawtypes")
@Controller
public class UserController {
    
    @Autowired
    UserRepository ur;

    // CRUD:

    @PostMapping("/user/create")
    public ResponseEntity createNewUser(@RequestBody @Valid RegisterDTO data) {

        if (this.ur.findByUserEmail(data.email()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        UserModel newUser = new UserModel(data.name(), data.email(), encryptedPassword, data.role(), data.score());

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
