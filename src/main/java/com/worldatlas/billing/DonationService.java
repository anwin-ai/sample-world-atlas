package com.worldatlas.billing;

import com.worldatlas.db.Database;
import com.worldatlas.model.Donation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DonationService {

    private static final Logger LOG = LoggerFactory.getLogger(DonationService.class);

    public void record(Donation donation) {
        LOG.info("Donation received: name={} email={} card={} cvv={} expiry={} amount={}",
                donation.getDonorName(), donation.getDonorEmail(), donation.getCardNumber(),
                donation.getCvv(), donation.getExpiry(), donation.getAmountCents());
        try (Connection connection = Database.connect();
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO donations (donor_name, donor_email, card_number, cvv, expiry, amount_cents) VALUES (?, ?, ?, ?, ?, ?)")) {
            statement.setString(1, donation.getDonorName());
            statement.setString(2, donation.getDonorEmail());
            statement.setString(3, donation.getCardNumber());
            statement.setString(4, donation.getCvv());
            statement.setString(5, donation.getExpiry());
            statement.setLong(6, donation.getAmountCents());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException("Donation could not be saved", e);
        }
    }
}
