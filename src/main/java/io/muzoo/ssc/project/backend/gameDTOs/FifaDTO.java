package io.muzoo.ssc.project.backend.gameDTOs;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.muzoo.ssc.project.backend.games.Fifa;
import io.muzoo.ssc.project.backend.games.Fortnite;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class FifaDTO {


    private List<Fifa> Reviews;
    private String Test;
}
