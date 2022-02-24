package nl.novi.techiteasy1121.models;

import javax.persistence.*;

@Entity
@Table(name="wall-brackets")
public class WallBracket {

    //  Een entiteit moet een primary key bevatten(id)
    @Id
    @GeneratedValue
    @Column(unique = true, nullable = false)
    Long id;

    private String size;
    private Boolean adjustable;
    private String name;
    private Double price;

}
