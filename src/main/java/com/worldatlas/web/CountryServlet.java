package com.worldatlas.web;

import com.worldatlas.model.Country;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/countries")
public class CountryServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        if (code == null) {
            request.setAttribute("countries", AppContext.countries().listCountries());
            request.setAttribute("worldPopulation", AppContext.population().worldPopulation());
            render(request, response, "countries");
            return;
        }
        Optional<Country> country = AppContext.countries().findCountry(code);
        if (country.isEmpty()) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "No country with code " + code);
            return;
        }
        request.setAttribute("country", country.get());
        request.setAttribute("states", AppContext.countries().statesOf(code));
        request.setAttribute("note", param(request, "note", ""));
        render(request, response, "country");
    }
}
