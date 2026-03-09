package com.rubev.GServices.model;

import lombok.Getter;

@Getter
public enum CategoriesServices {
    GYMS_AND_TRAINING("GYMS AND TRAINING"),
    VEHICLE_RENTAL("VEHICLE RENTAL"),
    HOTELS_AND_LODGING("HOTELS AND LODGING"),
    EVENT_HALLS("EVENT HALLS"),
    CINEMAS_AND_THEATERS("CINEMAS AND THEATERS"),
    SPA_AND_MASSAGES("SPA AND MASSAGES"),
    RESTAURANTS_AND_BARS("RESTAURANTS AND BARS"),
    OTHERS("OTHERS");

    private final String label;

    CategoriesServices(String label) {
        this.label = label;
    }

}
