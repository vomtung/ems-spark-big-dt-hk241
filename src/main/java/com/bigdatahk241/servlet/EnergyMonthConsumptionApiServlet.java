package com.bigdatahk241.servlet;




import com.bigdatahk241.dto.ConsumedEnergyMonthDto;
import com.bigdatahk241.service.EMSAggMonthFactory;
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

        List<ConsumedEnergyMonthDto> dto = EMSAggMonthFactory.consumedEnergyByMonth();

        ObjectMapper mapper = new ObjectMapper();
        String result =  mapper.writeValueAsString(dto);
        resp.getWriter().write(result);
    }
}
