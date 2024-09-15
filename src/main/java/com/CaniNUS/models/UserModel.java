package com.CaniNUS.models;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

// import com.CaniNUS.dto.UserRequestDTO;
import com.CaniNUS.enums.ERole;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
// import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class UserModel implements UserDetails {

    // Attributes:

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @NotEmpty
    // @Size(min = 3, max = 80)
    @Column(name = "name")
    private String userName;

    @Email
    @NotEmpty
    // @Size(min = 3, max = 48)
    @Column(name = "email")
    private String userEmail;

    @NotEmpty
    // @Size(min = 8, max = 32)
    @Column(name = "password")
    private String userPassword;

    @Enumerated
    @NotNull
    @Column(name = "role")
    private ERole userRole;

    @Column(name = "score")
    private float score; // Transformar depois para + notas

    // cpf
    // birthday

    // Constructors:
    
    public UserModel() {};

    // SignUp:
    public UserModel(String name, String email, String password, ERole role, float score) {
        this.userName = name;
        this.userEmail = email;
        this.userPassword = password;
        this.userRole = role;
        this.score = score;
    }

    // public UserModel(UserRequestDTO data) {
    //     this.userName = data.name();
    //     this.userEmail = data.email();
    //     this.userPassword = data.password();
    // }

    // Getters And Setters:

    public String getUserName() {
        return userName;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return userPassword;
    }

    @Override
    public String getUsername() {
        return userEmail;
    }

}
