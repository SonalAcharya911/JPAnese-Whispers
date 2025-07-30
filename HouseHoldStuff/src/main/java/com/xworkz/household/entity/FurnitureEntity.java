package com.xworkz.household.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="furniture_info")
public class FurnitureEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "furniture_id")
    private int furnitureID;

    @Column(name = "furniture_name")
    private String name;

    @Column(name = "furniture_price")
    private double price;

    @Column(name = "furniture_material")
    private String material;

    @Column(name = "furniture_color")
    private String color;

    @Column(name = "furniture_size")
    private char size;
}
