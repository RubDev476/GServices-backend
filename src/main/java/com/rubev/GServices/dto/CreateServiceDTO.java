package com.rubev.GServices.dto;

import com.rubev.GServices.model.AvailabilityServices;
import com.rubev.GServices.model.CategoriesServices;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateServiceDTO {
    private Long userId;
    private String urlImage;
    private String description;
    private Integer price;
    private AvailabilityServices availability;
    private CategoriesServices categories;
    private String location;
    private String name;
}
