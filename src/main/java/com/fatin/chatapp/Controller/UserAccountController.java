package com.fatin.chatapp.Controller;

import com.fatin.chatapp.dto.UserDTO;
import com.fatin.chatapp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@AllArgsConstructor
@Controller
@RequestMapping("/register")
public class UserAccountController {
    private UserService userService;

    public String registerAccount(@ModelAttribute("user") UserDTO userDTO, BindingResult result, Model model){
        if (result.hasErrors()){
            model.addAttribute("user",userDTO);
            return "/register";
        }
        userService.save(userDTO);
        return "redirect:/register?success";
    }
}
