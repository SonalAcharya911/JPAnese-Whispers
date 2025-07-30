package com.xworkz.bakery.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name="chocolate_info")
public class ChocolateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chocolate_id")
    private int chocolateID;

    @Column(name = "chocolate_name")
    private String chocolateName;

    @Column(name = "chocolate_type")
    private String chocolateType;

    @Column(name = "chocolate_brand")
    private String brand;

    @Column(name = "chocolate_expiry_date")
    private Date expiryDate;

    @Column(name = "number_of_chocolates")
    private int numOfChocolates;

    @Column(name="chocolate_price")
    private double chocolatePrice;
}
