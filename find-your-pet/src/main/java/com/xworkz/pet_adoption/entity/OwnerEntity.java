package com.xworkz.pet_adoption.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="owner_info")
public class OwnerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "owner_id")
    private int ownerID;

    @Column(name = "owner_name")
    private String ownerName;

    @Column(name = "owner_email")
    private String email;

    @Column(name = "owner_contact")
    private long contact;

    @Column(name = "owner_address")
    private String address;
}
