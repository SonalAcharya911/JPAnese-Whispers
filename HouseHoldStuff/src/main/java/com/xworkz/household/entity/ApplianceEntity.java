package com.xworkz.household.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="appliance_info")
public class ApplianceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="appliance_id")
    private int applianceID;

    @Column(name = "appliance_name")
    private String applianceName;

    @Column(name = "appliance_type")
    private String applianceType;

    @Column(name = "brand")
    private String brand;

    @Column(name = "power_usage")
    private int powerUsage;

    @Column(name = "warranty")
    private int warranty;
}
