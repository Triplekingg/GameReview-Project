package io.muzoo.ssc.project.backend.review;


import io.muzoo.ssc.project.backend.User;
import io.muzoo.ssc.project.backend.UserRepository;
import io.muzoo.ssc.project.backend.gamerepositories.FortniteRepository;
import io.muzoo.ssc.project.backend.games.Fortnite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ReviewController {

    @Autowired
    private FortniteRepository fortniteRepository;



    @PostMapping("/api/review")
    public void review(HttpServletRequest request){
        String review = request.getParameter("review");
        // Put try aroudn the statement because we use nested dot notation which could raise a NullPointerException
        try {
            Fortnite fortnite = new Fortnite();
            fortnite.setReviews(review);
            fortniteRepository.save(fortnite);

            }
         catch(Exception e){
        }
    }
}
