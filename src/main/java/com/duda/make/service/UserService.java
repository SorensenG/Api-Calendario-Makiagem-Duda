package com.duda.make.service;

import com.duda.make.dto.UserRegisterDTO;
import com.duda.make.entity.User;
import com.duda.make.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;

//registrar o usuario
    public User register(UserRegisterDTO dto){
        User user = User.builder()
                .username(dto.username())
                .password(dto.password())
                .email(dto.email())
                .phone(dto.phone())
                .address(dto.address())
                .role(dto.role())
                .build();

        return repo.save(user);
    }
}







