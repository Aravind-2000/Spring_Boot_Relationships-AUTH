package com.futura.test.Auth;


import org.springframework.stereotype.Service;

@Service
public class UserService {

    public UserDTO listUser(User user){

        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        dto.setUsername(user.getUsername());
        dto.setRoleId(user.getRoleId());
        dto.setRole(user.getRole());
        return dto;
    }


}
