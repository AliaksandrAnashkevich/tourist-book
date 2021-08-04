package com.intetics.touristbook.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "posts", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "location")
    @Pattern(regexp = "^[A-Za-z]+$")
    private String location;

    @Column(name = "description")
    private String description;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "temperature", nullable = false)
    private BigDecimal temperature;

    @Column(name = "weather", nullable = false)
    private String weather;

}
