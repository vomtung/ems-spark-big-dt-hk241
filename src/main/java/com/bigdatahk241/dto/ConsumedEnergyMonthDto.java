package com.bigdatahk241.dto;


import java.io.Serializable;

/**
 * ConsumedEnergyYearDto
 *
 * @author vmtung.sdh231@hcmut.edu.vn, vomtung@gmail.com
 * @since 28.Otc.2024
 */

public class ConsumedEnergyMonthDto implements Serializable {

    private Integer monthNo;
    private String month;
    private Double energyConsumption;

    public ConsumedEnergyMonthDto() {
    }

    public ConsumedEnergyMonthDto(Integer monthNo, String month, Double energyConsumption) {
        this.monthNo = monthNo;
        this.month = month;
        this.energyConsumption = energyConsumption;
    }

    public Integer getMonthNo() {
        return monthNo;
    }

    public void setMonthNo(Integer monthNo) {
        this.monthNo = monthNo;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Double getEnergyConsumption() {
        return energyConsumption;
    }

    public void setEnergyConsumption(Double energyConsumption) {
        this.energyConsumption = energyConsumption;
    }
}
