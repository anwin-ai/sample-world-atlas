package com.worldatlas.web;

import com.worldatlas.model.Donation;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/donate")
public class DonationServlet extends BaseServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Donation donation = new Donation(request.getParameter("name"), request.getParameter("email"),
                request.getParameter("cardNumber"), request.getParameter("cvv"), request.getParameter("expiry"),
                Long.parseLong(param(request, "amountCents", "500")));
        AppContext.donations().record(donation);
        writeText(response, "text/plain", "Thank you, " + donation.getDonorName());
    }
}
