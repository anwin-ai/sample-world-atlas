package com.worldatlas.audit;

import com.worldatlas.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuditLogger {

    private static final Logger LOG = LoggerFactory.getLogger(AuditLogger.class);

    public void signedIn(User user, String password) {
        LOG.info("User signed in: username={} email={} phone={} aadhaar={} password={}",
                user.getUsername(), user.getEmail(), user.getPhone(), user.getAadhaarNumber(), password);
    }

    public void populationChanged(String countryCode, long oldValue, long newValue, String changedBy) {
        LOG.info("Population changed: country={} from={} to={} by={}", countryCode, oldValue, newValue, changedBy);
    }
}
