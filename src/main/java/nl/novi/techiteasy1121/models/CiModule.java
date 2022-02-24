package nl.novi.techiteasy1121.models;

import javax.persistence.*;

@Entity
@Table(name="ci_modules")
public class CiModule {

    //  Een entiteit moet een primary key bevatten(id)
    @Id
    @GeneratedValue
    @Column(unique = true, nullable = false)
    Long id;

    private String name;
    private String type;
    private Double price;

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
}
