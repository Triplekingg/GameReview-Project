package io.muzoo.ssc.project.backend.Signup;


import io.muzoo.ssc.project.backend.User;
import io.muzoo.ssc.project.backend.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;

public class SignUpController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/api/signup")
    public SignUpDTO signUp(){
        // Put try aroudn the statement because we use nested dot notation which could raise a NullPointerException
        try {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if(principal != null && principal instanceof org.springframework.security.core.userdetails.User){
                // user is logged in
                org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) principal;
                User u = userRepository.findFirstByUsername(user.getUsername());

                return SignUpDTO.builder()
                        .loggedIn(true)
                        .name(u.getUsername()) // we dont have a name field so use username but you can add it yourseld
                        .role(u.getRole())
                        .username(u.getUsername())
                        .build();
            }
        } catch(Exception e){

        }
        // user is not logged in
        return SignUpDTO.builder()
                .loggedIn(false)
                .build();

    }
}
