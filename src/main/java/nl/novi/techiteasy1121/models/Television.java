package nl.novi.techiteasy1121.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "televisions")
public class Television {

    //  Een entiteit moet een primary key bevatten(id)
    @Id
    @GeneratedValue
    @Column(unique = true, nullable = false)
    Long id;

    @ManyToMany
    @JoinTable(
            name = "television_wallbrackets",
            joinColumns = @JoinColumn(name = "wallbracket_id"),
            inverseJoinColumns = @JoinColumn(name = "television_id"))
    private Set<WallBracket> wallBrackets = new HashSet<>();

    @ManyToOne
    @JsonIgnore
    @JoinColumn(
            name = "ci_module_id",
            referencedColumnName = "id",
            nullable = true)
    @JsonManagedReference
    private CiModule ciModule;

    @OneToOne
    @JsonIgnore
    @JoinColumn(
            name = "remotecontroller_id",
            referencedColumnName = "id")
    private Remotecontroller remotecontroller;

    private String type;
    private String brand;
    private String name;
    private Double price;
    private Double availableSize;
    private Double refreshRate;
    private String screenType;
    private String screenQuality;
    private Boolean smartTv;
    private Boolean wifi;
    private Boolean voiceControl;
    private Boolean hdr;
    private Boolean bluetooth;
    private Boolean ambiLight;
    private Integer originalStock;
    private Integer sold;

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType( String type ) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand( String brand ) {
        this.brand = brand;
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

    public Double getAvailableSize() {
        return availableSize;
    }

    public void setAvailableSize( Double availableSize ) {
        this.availableSize = availableSize;
    }

    public Double getRefreshRate() {
        return refreshRate;
    }

    public void setRefreshRate( Double refreshRate ) {
        this.refreshRate = refreshRate;
    }

    public String getScreenType() {
        return screenType;
    }

    public void setScreenType( String screenType ) {
        this.screenType = screenType;
    }

    public String getScreenQuality() {
        return screenQuality;
    }

    public void setScreenQuality( String screenQuality ) {
        this.screenQuality = screenQuality;
    }

    public Boolean getSmartTv() {
        return smartTv;
    }

    public void setSmartTv( Boolean smartTv ) {
        this.smartTv = smartTv;
    }

    public Boolean getWifi() {
        return wifi;
    }

    public void setWifi( Boolean wifi ) {
        this.wifi = wifi;
    }

    public Boolean getVoiceControl() {
        return voiceControl;
    }

    public void setVoiceControl( Boolean voiceControl ) {
        this.voiceControl = voiceControl;
    }

    public Boolean getHdr() {
        return hdr;
    }

    public void setHdr( Boolean hdr ) {
        this.hdr = hdr;
    }

    public Boolean getBluetooth() {
        return bluetooth;
    }

    public void setBluetooth( Boolean bluetooth ) {
        this.bluetooth = bluetooth;
    }

    public Boolean getAmbiLight() {
        return ambiLight;
    }

    public void setAmbiLight( Boolean ambiLight ) {
        this.ambiLight = ambiLight;
    }

    public Integer getOriginalStock() {
        return originalStock;
    }

    public void setOriginalStock( Integer originalStock ) {
        this.originalStock = originalStock;
    }

    public Integer getSold() {
        return sold;
    }

    public void setSold( Integer sold ) {
        this.sold = sold;
    }


    public Remotecontroller getRemotecontroller() {
        return remotecontroller;
    }

    public void setRemotecontroller( Remotecontroller remotecontroller ) {
        this.remotecontroller = remotecontroller;
    }

    public void setCiModule( CiModule ciModule ) {
        this.ciModule = ciModule;
    }

    public CiModule getCiModule() {
        return ciModule;
    }


    public Set<WallBracket> getWallBrackets() {
        return wallBrackets;
    }
//
//    public void setWallBracket( Set<WallBracket> wallBrackets ) {
//        this.wallBrackets = wallBrackets;
//    }

}