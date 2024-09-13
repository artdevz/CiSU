package com.CaniNUS.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.CaniNUS.dto.LoginDTO;
import com.CaniNUS.dto.LoginResponseDTO;
import com.CaniNUS.dto.RegisterDTO;
import com.CaniNUS.models.UserModel;
import com.CaniNUS.repositories.UserRepository;
import com.CaniNUS.services.TokenService;

import jakarta.validation.Valid;

@SuppressWarnings("rawtypes")
@Controller
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    UserRepository ur;

    @Autowired
    private TokenService ts;
    
    @PostMapping("/signup")
    public ResponseEntity signUpAccount(@RequestBody @Valid RegisterDTO data) {
        
        if (this.ur.findByUserEmail(data.email()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        UserModel newUser = new UserModel(data.name(), data.email(), encryptedPassword, data.role());

        this.ur.save(newUser);

        return ResponseEntity.ok().build();

    }

    @PostMapping("/signin")
    public ResponseEntity signInAccount(@RequestBody @Valid LoginDTO data) {
        
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = ts.generateToken( (UserModel) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));

    }

    // @PostMapping("/signout")

}
