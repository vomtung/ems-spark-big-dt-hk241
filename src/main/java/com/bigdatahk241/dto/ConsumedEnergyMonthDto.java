package com.bigdatahk241.dto;


import java.io.Serializable;

/**
 * ConsumedEnergyMonthDto
 *
 * @author vmtung.sdh231@hcmut.edu.vn, vomtung@gmail.com
 * @since 30.Nov.2024
 */

public class ConsumedEnergyMonthDto implements Serializable {

    private Integer month;
    private Double energyConsumption;

    public ConsumedEnergyMonthDto() {
    }

    public ConsumedEnergyMonthDto(Integer month,Double energyConsumption) {
        this.month = month;
        this.energyConsumption = energyConsumption;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Double getEnergyConsumption() {
        return energyConsumption;
    }

    public void setEnergyConsumption(Double energyConsumption) {
        this.energyConsumption = energyConsumption;
    }
}
