package com.rubev.GServices.model;

import lombok.Getter;

@Getter
public enum AvailabilityServices {
    AVAILABLE("AVAILABLE"),
    OUT_OF_STOCK("OUT OF STOCK"),
    COMING_SOON("COMING SOON");

    private final String label;

    AvailabilityServices(String label) {
        this.label = label;
    }

}
