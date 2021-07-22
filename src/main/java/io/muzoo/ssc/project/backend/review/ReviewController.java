package io.muzoo.ssc.project.backend.review;


import com.fasterxml.jackson.core.JsonGenerator;
import io.muzoo.ssc.project.backend.User;
import io.muzoo.ssc.project.backend.UserRepository;
import io.muzoo.ssc.project.backend.gamerepositories.FifaRepository;
import io.muzoo.ssc.project.backend.gamerepositories.FortniteRepository;
import io.muzoo.ssc.project.backend.games.Fifa;
import io.muzoo.ssc.project.backend.games.Fortnite;
import net.minidev.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
public class ReviewController {

    @Autowired
    private FortniteRepository fortniteRepository;

    @Autowired
    private FifaRepository fifaRepository;



    @PostMapping("/api/review")
    public void review(HttpServletRequest request){
        String review = request.getParameter("review");
        String name = request.getParameter("gameName");
        // Put try aroudn the statement because we use nested dot notation which could raise a NullPointerException
        try {
            if(name.equals("Fifa")){
                Fifa fifa = new Fifa();
                fifa.setReviews(review);
                fifaRepository.save(fifa);
            }
            else if(name.equals("Fortnite")){
                Fortnite fortnite = new Fortnite();
                fortnite.setReviews(review);
                fortniteRepository.save(fortnite);
            }
            List<Fortnite> all = fortniteRepository.findAll();
        }
         catch(Exception e){
        }
    }
    @GetMapping("/api/review/fortnite")
    public ReviewDTO fetchFortniteReviews(){
        // Put try aroudn the statement because we use nested dot notation which could raise a NullPointerException
        try {
            List<Fortnite> all = fortniteRepository.findAll();
            List<String> reviews = new ArrayList<>();
            for (Fortnite f:all
                 ) {
                reviews.add(f.getReviews());
            }
            return ReviewDTO.builder().Reviews(reviews).Test("Failed just kidding ").build();
        }
        catch(Exception e){
        }
        return null;
    }
}
