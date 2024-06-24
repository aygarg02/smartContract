package com.smartContract.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/users")
public class UserController {
  
    
    @GetMapping("/index")
    public String getMethodName() {
      return "normal/User";
    }
    
    
}
