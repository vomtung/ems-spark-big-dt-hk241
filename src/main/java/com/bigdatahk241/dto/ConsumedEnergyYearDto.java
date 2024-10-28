package com.bigdatahk241.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * ConsumedEnergyYearDto
 *
 * @author vmtung.sdh231@hcmut.edu.vn, vomtung@gmail.com
 * @since 28.Otc.2024
 */
@AllArgsConstructor
@Data
public class ConsumedEnergyYearDto implements Serializable {

    private Integer deviceId;
    private String deviceName;
    private Double energyConsumption;
}
