package com.futura.test.Auth;

import com.futura.test.Entity.Role;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserDTO {

    private Long id;
    private String email;
    private String username;
    private Long roleId;
    private Role role;

}
