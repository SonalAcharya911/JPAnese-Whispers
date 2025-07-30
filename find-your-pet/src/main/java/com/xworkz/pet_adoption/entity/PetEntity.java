package com.xworkz.pet_adoption.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="pet_info")
public class PetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pet_id")
    private int petID;

    @Column(name = "animal_type")
    private String animalType;

    @Column(name = "pet_breed")
    private String breed;

    @Column(name = "pet_age")
    private int age;

    @Column(name = "pet_color")
    private String color;

    @Column(name = "pet_food")
    private String food;

    @Column(name = "pet_enclosure_number")
    private int enclosureNumber;
}
