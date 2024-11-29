package com.bigdatahk241.servlet;




import com.bigdatahk241.dto.ConsumedEnergyMonthDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * EnergyYearConsumptionApiServlet
 *
 * @author vmtung.sdh231@hcmut.edu.vn, vomtung@gmail.com
 * @since 29.Nov.2024
 */
public class EnergyMonthConsumptionApiServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");


        ConsumedEnergyMonthDto month1Dto = new ConsumedEnergyMonthDto(1,"Janary", 3122.0);
        ConsumedEnergyMonthDto month2Dto = new ConsumedEnergyMonthDto(2, "February", 1235.0);
        ConsumedEnergyMonthDto month3Dto = new ConsumedEnergyMonthDto(3, "March",1233.0);
        ConsumedEnergyMonthDto month4Dto = new ConsumedEnergyMonthDto(4, "April",1247.0);
        ConsumedEnergyMonthDto month5Dto = new ConsumedEnergyMonthDto(5, "May",3246.0);
        ConsumedEnergyMonthDto month6Dto = new ConsumedEnergyMonthDto(6, "June",4342.0);
        ConsumedEnergyMonthDto month7Dto = new ConsumedEnergyMonthDto(7, "July",6353.0);
        ConsumedEnergyMonthDto month8Dto = new ConsumedEnergyMonthDto(8, "August",8259.0);
        ConsumedEnergyMonthDto month9Dto = new ConsumedEnergyMonthDto(9, "September",9328.0);
        ConsumedEnergyMonthDto month10Dto = new ConsumedEnergyMonthDto(10, "October",7936.0);
        ConsumedEnergyMonthDto month11Dto = new ConsumedEnergyMonthDto(11, "November",6749.0);
        ConsumedEnergyMonthDto month12Dto = new ConsumedEnergyMonthDto(12, "December",8908.0);


        List<ConsumedEnergyMonthDto> dto =  Arrays.asList(month1Dto,
                month2Dto,
                month3Dto,
                month4Dto,
                month5Dto,
                month6Dto,
                month7Dto,
                month8Dto,
                month9Dto,
                month10Dto,
                month11Dto,
                month12Dto);

        ObjectMapper mapper = new ObjectMapper();
        String result =  mapper.writeValueAsString(dto);
        resp.getWriter().write(result);
    }
}
