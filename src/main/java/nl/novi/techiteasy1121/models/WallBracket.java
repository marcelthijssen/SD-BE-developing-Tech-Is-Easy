package nl.novi.techiteasy1121.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="wall_brackets")
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

    @JsonIgnore
    @ManyToMany(mappedBy = "wallBrackets")
    private  Set<Television> televisions = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize( String size ) {
        this.size = size;
    }

    public Boolean getAdjustable() {
        return adjustable;
    }

    public void setAdjustable( Boolean adjustable ) {
        this.adjustable = adjustable;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice( Double price ) {
        this.price = price;
    }

    public Set<Television> getTelevisions() {
        return televisions;
    }

    public void setTelevisions(Set<Television> televisions) {
        this.televisions = televisions;
    }

}
