package com.fatin.chatapp.Controller;

import com.fatin.chatapp.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AccountController {
    @GetMapping("/register")
    public String register(@ModelAttribute UserDTO userDTO, Model model){
        model.addAttribute("userDTO",userDTO);
        return "register";
    }
    @PostMapping("/register")
    public void save(UserDTO userDTO){

    }
}
