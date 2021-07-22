package io.muzoo.ssc.project.backend.review;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.muzoo.ssc.project.backend.games.Fortnite;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ReviewDTO {


    private List<Fortnite> Reviews;
    private String Test;
}
