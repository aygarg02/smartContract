package com.smartContract.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.smartContract.dao.UserRepo;
import com.smartContract.model.Consumer;
import com.smartContract.message.*;
import jakarta.servlet.http.HttpSession;


@Controller
public class HomeController {
@Autowired
UserRepo repo;



@GetMapping("/signin")
public String login(){
    return "login";
}
public String getMethodName(@RequestParam String param) {
    return new String();
}

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/signup")
    public String signUp(Model model){
        model.addAttribute("user",new Consumer());
        return "signup";
    }
    
  
    @PostMapping("/do_register")
    public String registerUser(@ModelAttribute("user") Consumer consumer,
                               @RequestParam(value = "aggrement", defaultValue = "false") boolean aggrement,
                               Model model, RedirectAttributes redirectAttributes) {
        try {
            if (!aggrement) {
                throw new Exception("You must agree to the terms and conditions.");
            }
            consumer.setRole("normal_user");
            consumer.setEnabled(true);
            consumer.setImageUrl("default/image.png");
            repo.save(consumer);
            System.out.println(consumer);

            redirectAttributes.addFlashAttribute("message", new Message("Registration successful!", "alert-success"));
            return "redirect:/signup";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("user", consumer);
            redirectAttributes.addFlashAttribute("message", new Message("There was an error during registration: " + e.getMessage(), "alert-danger"));
            return "redirect:/signup";
        }
    }
}
