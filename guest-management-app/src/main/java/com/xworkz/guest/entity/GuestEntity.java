package com.xworkz.guest.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "guest_info")


@NamedQuery(name="findByName",query = "select g from GuestEntity g where g.guestName=: guestName")
@NamedQuery(name="findByEmail",query = "select g from GuestEntity g where g.email=: email")
@NamedQuery(name="findByContact",query = "select g from GuestEntity g where g.contactNumber=: contact")

public class GuestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "guest_id")
    private Integer guestID;

    @Column(name = "guest_name")
    private String guestName;

    @Column(name = "guest_contact")
    private Long contactNumber;

    @Column(name = "guest_email")
    private String email;

    @Column(name = "rsvp_status")
    private String rsvpStatus;

    @Column(name = "guest_food_preference")
    private String foodPreference;

}
