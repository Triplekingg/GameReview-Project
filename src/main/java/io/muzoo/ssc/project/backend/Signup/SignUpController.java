package io.muzoo.ssc.project.backend.Signup;


import io.muzoo.ssc.project.backend.User;
import io.muzoo.ssc.project.backend.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class SignUpController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/api/signup")
    public void signUp(HttpServletRequest request){
        String username = request.getParameter("username");
        String displayName = request.getParameter("displayName");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        // Put try aroudn the statement because we use nested dot notation which could raise a NullPointerException
        try {
                if(userRepository.findFirstByUsername(username)==null){
                    User user = new User();
                    user.setUsername(username);
                    user.setPassword(passwordEncoder.encode(password));
                    user.setRole("USER");
                    user.setDisplayName(displayName);
                    userRepository.save(user);
            }
        } catch(Exception e){
        }
    }
}
