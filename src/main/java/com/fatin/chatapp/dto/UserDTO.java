package com.fatin.chatapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDTO {
    @NotEmpty
    private String name;
    @NotEmpty
    private String username;
    @NotEmpty (message = "Email cannot be empty")
    @Email
    private String email;
    @NotEmpty (message = "Password cannot be empty")
    private String password;

}
