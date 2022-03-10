package nl.novi.techiteasy1121.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "ciModules")
public class CiModule {

    //  Een entiteit moet een primary key bevatten(id)
    @Id
    @GeneratedValue
    @Column(unique = true, nullable = false)
    Long id;


    private String name;
    private String type;
    private Double price;


    //    @ManyToOne
    @OneToMany(mappedBy = "ciModule",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
//    @JsonBackReference
    @JsonIgnore
    private List<Television> televisions;


    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType( String type ) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice( Double price ) {
        this.price = price;
    }

    public void setTelevision(List<Television> television) {
        this.televisions = televisions;
    }

    public List<Television> getTelevisions() {
        return televisions;
    }

    void addTelevision( Television television) {
        this.televisions.add(television);
    }
}
