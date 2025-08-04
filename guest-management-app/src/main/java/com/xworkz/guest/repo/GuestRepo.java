package com.xworkz.guest.repo;

import com.xworkz.guest.entity.GuestEntity;

public interface GuestRepo {
    boolean save(GuestEntity guestEntity);

    boolean deleteGuestByName(String name);

    void updateGuestName(int id, String oldName, String newName);

    GuestEntity findByID(int id);

    GuestEntity findByName(String name);

    GuestEntity findByContact(Long contact);

    GuestEntity findByEmail(String email);
}
