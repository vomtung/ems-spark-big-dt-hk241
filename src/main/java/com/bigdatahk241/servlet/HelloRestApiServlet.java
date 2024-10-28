package com.bigdatahk241.servlet;




import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * HelloRestApiServlet
 *
 * @author vmtung.sdh231@hcmut.edu.vn, vomtung@gmail.com
 * @since 28.Otc.2024
 */
public class HelloRestApiServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.getWriter().write("{\"message\": \"Hello, World!\"}");
    }
}
