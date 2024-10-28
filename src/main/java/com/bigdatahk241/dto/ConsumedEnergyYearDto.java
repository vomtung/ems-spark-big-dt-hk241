package com.bigdatahk241.dto;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * ConsumedEnergyYearDto
 *
 * @author vmtung.sdh231@hcmut.edu.vn, vomtung@gmail.com
 * @since 28.Otc.2024
 */

public class ConsumedEnergyYearDto implements Serializable {

    private Integer year;
    private Double energyConsumption;

    public ConsumedEnergyYearDto() {
    }

    public ConsumedEnergyYearDto(Integer year, Double energyConsumption) {
        this.year = year;
        this.energyConsumption = energyConsumption;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Double getEnergyConsumption() {
        return energyConsumption;
    }

    public void setEnergyConsumption(Double energyConsumption) {
        this.energyConsumption = energyConsumption;
    }
}
