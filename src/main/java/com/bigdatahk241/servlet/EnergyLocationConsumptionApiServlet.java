package com.bigdatahk241.servlet;




import com.bigdatahk241.dto.ConsumedEnergyLocationDto;
import com.bigdatahk241.dto.ConsumedEnergyMonthDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * EnergyYearConsumptionApiServlet
 *
 * @author vmtung.sdh231@hcmut.edu.vn, vomtung@gmail.com
 * @since 29.Nov.2024
 */
public class EnergyLocationConsumptionApiServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");


        ConsumedEnergyLocationDto floor1Dto = new ConsumedEnergyLocationDto("floor1", 3122.0);
        ConsumedEnergyLocationDto floor2Dto = new ConsumedEnergyLocationDto("foor2", 2235.0);
        ConsumedEnergyLocationDto floor3Dto = new ConsumedEnergyLocationDto("foor3",1233.0);
        ConsumedEnergyLocationDto floor4Dto = new ConsumedEnergyLocationDto("floor4",5247.0);
        ConsumedEnergyLocationDto floor5Dto = new ConsumedEnergyLocationDto("floor5",1247.0);


        List<ConsumedEnergyLocationDto> dto =  Arrays.asList(floor1Dto,
                floor2Dto,
                floor3Dto,
                floor4Dto,
                floor5Dto);

        ObjectMapper mapper = new ObjectMapper();
        String result =  mapper.writeValueAsString(dto);
        resp.getWriter().write(result);
    }
}
