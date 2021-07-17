package io.muzoo.ssc.project.backend.auth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@RestController
public class AuthenticationController {

    @GetMapping("/api/test")
    public String test(){
        return "if you see this login is successful";
    }

    @PostMapping("/api/login")
    public String login(HttpServletRequest request){

        String username= request.getParameter("username");
        String password= request.getParameter("password");
        try{
            request.login(username,password);
            return "Login Successful";
        }
        catch(ServletException e){
            return "Failed to Login";
        }




    }

    @GetMapping("/api/logout")
    public String logout(HttpServletRequest request){
        try {
            request.logout();
            return "Logout Successful";
        } catch (ServletException e) {
            return " Failed to Logout ";
        }


    }



}
