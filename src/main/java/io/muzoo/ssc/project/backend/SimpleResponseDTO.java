package io.muzoo.ssc.project.backend;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
@Builder

public class SimpleResponseDTO {

    public boolean success;
    private String message;
}
