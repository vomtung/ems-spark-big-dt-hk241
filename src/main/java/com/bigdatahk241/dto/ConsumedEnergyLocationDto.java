package com.bigdatahk241.dto;


import java.io.Serializable;

/**
 * ConsumedEnergyLocationDto
 *
 * @author vmtung.sdh231@hcmut.edu.vn, vomtung@gmail.com
 * @since 29.Nov.2024
 */

public class ConsumedEnergyLocationDto implements Serializable {

    private String location;
    private Double energyConsumption;

    public ConsumedEnergyLocationDto() {
    }

    public ConsumedEnergyLocationDto(String location, Double energyConsumption) {
        this.location = location;
        this.energyConsumption = energyConsumption;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getEnergyConsumption() {
        return energyConsumption;
    }

    public void setEnergyConsumption(Double energyConsumption) {
        this.energyConsumption = energyConsumption;
    }
}
