package io.muzoo.ssc.project.backend.gameDTOs;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.muzoo.ssc.project.backend.games.Horizon;
import io.muzoo.ssc.project.backend.games.Siege;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class HorizonDTO {


    private List<Horizon> Reviews;
    private String Test;
}
