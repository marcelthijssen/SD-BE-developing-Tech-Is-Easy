package nl.novi.techiteasy1121.dto;

import lombok.Data;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;


@Data
public class TelevisionDto {
    private Long id;

    @NotBlank(message = "Field 'type' can not be empty")
    private String type;

    @NotBlank(message = "Field 'brand' can not be empty")
    private String brand;

    @NotBlank(message = "Field 'name' can not be empty")
    private String name;

    @DecimalMin("0.0")
    private Double price;
    private Double availableSize;
    private Double refreshRate;

//    @NotBlank(message = "screentype not valid")
    private String screenType;

//    @NotBlank(message = "Screen quality not valid")
    private String screenQuality;

//    @NotNull(message = "smartTv no entry")
    private Boolean smartTv;

//    @NotNull(message = "wifi no entry")
    private Boolean wifi;

//    @NotNull(message = "voiceControl no entry")
    private Boolean voiceControl;

//    @NotNull(message = "hdr no entry")
    private Boolean hdr;

//    @NotNull(message = "bluetooth no entry")
    private Boolean bluetooth;

//    @NotNull(message = "ambiLight no entry")
    private Boolean ambiLight;

    private Integer originalStock;
    private Integer sold;

    // Een default constructor
    public TelevisionDto() {
    }

    // Een constructor met alle gevraagde variable
    public TelevisionDto(
            Long id,
            String type,
            String brand,
            String name,
            Double price,
            Double availableSize,
            Double refreshRate,
            String screenType,
            String screenQuality,
            Boolean smartTv,
            Boolean wifi,
            Boolean voiceControl,
            Boolean hdr,
            Boolean bluetooth,
            Boolean ambiLight,
            Integer originalStock,
            Integer sold ) {
        this.id = id;
        this.type = type;
        this.brand = brand;
        this.name = name;
        this.price = price;
        this.availableSize = availableSize;
        this.refreshRate = refreshRate;
        this.screenType = screenType;
        this.screenQuality = screenQuality;
        this.smartTv = smartTv;
        this.wifi = wifi;
        this.voiceControl = voiceControl;
        this.hdr = hdr;
        this.bluetooth = bluetooth;
        this.ambiLight = ambiLight;
        this.originalStock = originalStock;
        this.sold = sold;
    }


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
}
