package com.xworkz.ecommerce.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="clothings_info")
public class ClothingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cloth_id")
    private int clothID;

    @Column(name = "cloth_type")
    private String clothType;

    @Column(name = "color")
    private String color;

    @Column(name = "cloth_material")
    private String clothMaterial;

    @Column(name = "price")
    private double price;

    @Column(name = "return_by")
    private int returnBy;
}
