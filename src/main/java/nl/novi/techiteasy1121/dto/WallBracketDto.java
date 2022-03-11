package nl.novi.techiteasy1121.dto;

import lombok.Data;
import nl.novi.techiteasy1121.models.Television;

import java.util.HashSet;
import java.util.Set;

@Data
public class WallBracketDto {
    private Long id;

    private String size;
    private Boolean adjustable;
    private String name;
    private Double price;
//    Set<Television> televisions = new HashSet<>();

    public WallBracketDto() {
    }

    public WallBracketDto( Long id, String size, Boolean adjustable, String name, Double price ) {
        this.id = id;
        this.size = size;
        this.adjustable = adjustable;
        this.name = name;
        this.price = price;
    }

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


//    public Set<Television> getTelevisions() {
//        return televisions;
//    }

//    public void setTelevisions(Set<Television> televisions) {
//        this.televisions = televisions;
//    }
}
