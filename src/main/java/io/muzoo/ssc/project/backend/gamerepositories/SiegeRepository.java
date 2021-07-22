package io.muzoo.ssc.project.backend.gamerepositories;

import io.muzoo.ssc.project.backend.games.Fifa;
import io.muzoo.ssc.project.backend.games.Siege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiegeRepository extends JpaRepository<Siege, Long> {

}
