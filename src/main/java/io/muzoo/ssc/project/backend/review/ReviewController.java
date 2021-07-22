package io.muzoo.ssc.project.backend.review;


import io.muzoo.ssc.project.backend.User;
import io.muzoo.ssc.project.backend.UserRepository;
import io.muzoo.ssc.project.backend.gameDTOs.*;
import io.muzoo.ssc.project.backend.gamerepositories.*;
import io.muzoo.ssc.project.backend.games.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class ReviewController {

    @Autowired
    private FortniteRepository fortniteRepository;

    @Autowired
    private NbaRepository nbaRepository;

    @Autowired
    private SiegeRepository siegeRepository;

    @Autowired
    private FifaRepository fifaRepository;

    @Autowired
    private HorizonRepository horizonRepository;

    @Autowired
    private UserRepository userRepository;


    @PostMapping("/api/review")
    public void review(HttpServletRequest request) {
        String review = request.getParameter("review");
        String name = request.getParameter("gameName");

        // Put try aroudn the statement because we use nested dot notation which could raise a NullPointerException
        try {
            //Get current username so that we can keep track of the author of the review
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) principal;
            User u = userRepository.findFirstByUsername(user.getUsername());
            String username = u.getUsername();

            if (name.equals("Fifa")) {
                Fifa fifa = new Fifa();
                fifa.setReviews(review);
                fifa.setUsername(username);
                fifaRepository.save(fifa);
            } else if (name.equals("Fortnite")) {
                Fortnite fortnite = new Fortnite();
                fortnite.setReviews(review);
                fortnite.setUsername(username);
                fortniteRepository.save(fortnite);
            } else if (name.equals("Siege")) {
                Siege siege = new Siege();
                siege.setReviews(review);
                siege.setUsername(username);
                siegeRepository.save(siege);
            } else if (name.equals("Nba")) {
                Nba nba = new Nba();
                nba.setReviews(review);
                nba.setUsername(username);
                nbaRepository.save(nba);
            } else if (name.equals("Horizon")) {
                Horizon horizon = new Horizon();
                horizon.setReviews(review);
                horizon.setUsername(username);
                horizonRepository.save(horizon);
            }
        } catch (Exception e) {
        }
    }

    @GetMapping("/api/review/fortnite")
    public FortniteDTO fetchFortniteReviews() {
        // Put try aroudn the statement because we use nested dot notation which could raise a NullPointerException
        try {
            List<Fortnite> all = fortniteRepository.findAll();
            return FortniteDTO.builder().Reviews(all).Test("Failed just kidding ").build();
        } catch (Exception e) {
        }
        return null;
    }

    @GetMapping("/api/review/siege")
    public SiegeDTO fetchSiegeReviews() {
        // Put try aroudn the statement because we use nested dot notation which could raise a NullPointerException
        try {
            List<Siege> all = siegeRepository.findAll();
            return SiegeDTO.builder().Reviews(all).Test("Failed just kidding ").build();
        } catch (Exception e) {
        }
        return null;
    }

    @GetMapping("/api/review/fifa")
    public FifaDTO fetchFifaReviews() {
        // Put try aroudn the statement because we use nested dot notation which could raise a NullPointerException
        try {
            List<Fifa> all = fifaRepository.findAll();
            return FifaDTO.builder().Reviews(all).Test("Failed just kidding ").build();
        } catch (Exception e) {
        }
        return null;
    }

    @GetMapping("/api/review/nba")
    public NbaDTO fetchNbaReviews() {
        // Put try aroudn the statement because we use nested dot notation which could raise a NullPointerException
        try {
            List<Nba> all = nbaRepository.findAll();
            return NbaDTO.builder().Reviews(all).Test("Failed just kidding ").build();
        } catch (Exception e) {
        }
        return null;
    }

    @GetMapping("/api/review/horizon")
    public HorizonDTO fetchHorizonReviews() {
        // Put try aroudn the statement because we use nested dot notation which could raise a NullPointerException
        try {
            List<Horizon> all = horizonRepository.findAll();
            return HorizonDTO.builder().Reviews(all).Test("Failed just kidding ").build();
        } catch (Exception e) {
        }
        return null;
    }
}
