package org.example;

import java.util.function.Predicate;

public class IpAddressValidator  {

    public boolean ValidateIpv4Address(String address) {
        String[] parts = address.split("\\.");

        // Ensure that the IP address has four parts
        if (parts.length != 4) {
            return false;
        }

        // Check for the last part not being 0 or 255
        int lastPart = Integer.parseInt(parts[3]);
        if (lastPart == 0 || lastPart == 255) {
            // First and last octets are exceptions
                return false;

        }

        // Checking that each part is between 0 and 255
        for (String part : parts) {
            int value;
            try {
                value = Integer.parseInt(part);
            } catch (NumberFormatException e) {
                return false;
            }
            if (value < 0 || value > 255) {
                return false;
            }

        }

        return true;
    }
}
