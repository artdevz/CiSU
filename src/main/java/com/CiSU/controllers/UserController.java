package com.CiSU.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CiSU.dto.users.RegisterDTO;
// import com.CiSU.dto.users.UserRequestDTO;
// import com.CiSU.dto.users.UserResponseDTO;
import com.CiSU.models.UserModel;
import com.CiSU.repositories.UserRepository;
import com.CiSU.services.UserService;

import jakarta.annotation.Nullable;
import jakarta.validation.Valid;

@CrossOrigin("*")
@RequestMapping("/api/user")
@RestController
public class UserController {
    
    @Autowired
    UserRepository ur;

    @Autowired
    UserService us;

    // CRUD:

    @PostMapping("/create")
    public ResponseEntity<Nullable> createNewUser(@RequestBody @Valid RegisterDTO data) {

        if (this.ur.findByUserEmail(data.email()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        UserModel newUser = new UserModel(data.name(), data.email(), encryptedPassword, data.role(), us.randomizeScore());

        this.ur.save(newUser);

        return new ResponseEntity<>(HttpStatus.OK);

    }

    @GetMapping("/read")
    public ResponseEntity<List<UserModel>> readAllUsers() {

        //List<UserResponseDTO> userList = this.ur.findAll().stream().map(UserResponseDTO::new).toList();
        List<UserModel> userList = this.ur.findAll();

        return new ResponseEntity<>(userList, HttpStatus.OK);

    }

    // @PostMapping("/update")
    // public ResponseEntity updateUser(@RequestBody @Valid UserDTO data) {
    //     return ResponseEntity.ok.build();
    // }

    // Skill Issue :(
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Nullable> deleteUser(@PathVariable UUID id) {

        ur.deleteById(id);

        return new ResponseEntity<Nullable>(HttpStatus.OK);

    }

}
