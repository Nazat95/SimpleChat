package com.fatin.chatapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UserDTO {
    
    private String username;
    private String email;
    private String password;
    private String confirmPassword;

    public UserDTO(){

    }

}
