package com.bigdatahk241.servlet;




import com.bigdatahk241.dto.ConsumedEnergyYearDto;
import com.bigdatahk241.service.EMSAggYearFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

/**
 * EnergyYearConsumptionYearApiServlet
 *
 * @author vmtung.sdh231@hcmut.edu.vn, vomtung@gmail.com
 * @since 28.Otc.2024
 */
public class EnergyYearConsumptionYearApiServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");

        List<ConsumedEnergyYearDto> dto =  EMSAggYearFactory.consumedEnergyByYear();

        ObjectMapper mapper = new ObjectMapper();
        String result =  mapper.writeValueAsString(dto);
        resp.getWriter().write(result);
    }
}
