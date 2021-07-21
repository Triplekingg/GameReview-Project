package io.muzoo.ssc.project.backend.gamerepositories;

import io.muzoo.ssc.project.backend.games.Fifa;
import io.muzoo.ssc.project.backend.games.Fortnite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FifaRepository extends JpaRepository<Fifa, Long> {
//    Fifa findAllByReviews(String username);
}
