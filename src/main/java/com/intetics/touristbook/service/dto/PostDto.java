package com.intetics.touristbook.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {

    private int id;
    private BigDecimal temperature;
    private String location;
    private String description;
    private String username;
    private String weather;
    private LocalDate date;

}
