package io.muzoo.ssc.project.backend;



import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "review_table")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private String gamename;


    private String username;


    private String feedback;




}
