package com.duda.make.controller;

import com.duda.make.dto.AutanticantioDTO;
import com.duda.make.dto.UserRegisterDTO;
import com.duda.make.entity.User;
import com.duda.make.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserRepository repo;
    @Autowired
    private AuthenticationManager authenticationManager;




    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid UserRegisterDTO dto ){
       if (repo.findByUsername(dto.username()) != null){
           return ResponseEntity.badRequest().build();
       }

        String encryptedPassword = new BCryptPasswordEncoder().encode(dto.password());

        User user = User.builder()
                .username(dto.username())
                .password(encryptedPassword)
                .email(dto.email())
                .phone(dto.phone())
                .address(dto.address())
                .role(dto.role())
                .build();

      repo.save(user);

       return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AutanticantioDTO dto  ){
var usernamePassword = new UsernamePasswordAuthenticationToken(dto.username(), dto.password());

     var auth = this.authenticationManager.authenticate(usernamePassword);


     return ResponseEntity.ok().build();
         }

}
