package com.xworkz.ecommerce.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@AllArgsConstructor
@Table(name="footwear_info")
public class FootwearEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "footwear_id")
    private int footwearID;

    @Column(name = "footwear_name")
    private String footwearName;

    @Column(name = "footwear_brand")
    private String brand;

    @Column(name = "footwear_color")
    private String color;

    @Column(name = "footwear_price")
    private double price;

    @Column(name = "material")
    private String material;

}
