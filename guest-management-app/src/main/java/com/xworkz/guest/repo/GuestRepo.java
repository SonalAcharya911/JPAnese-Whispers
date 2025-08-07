package com.xworkz.guest.repo;

import com.xworkz.guest.entity.GuestEntity;

import java.util.List;

public interface GuestRepo {
    boolean save(GuestEntity guestEntity);

    boolean deleteGuestByName(String name);

    void updateGuestName(int id, String oldName, String newName);

    GuestEntity findByID(int id);

    GuestEntity findByName(String name);

    GuestEntity findByContact(Long contact);

    GuestEntity findByEmail(String email);

    int updateEmailByName(String email, String name);

    int updateRsvpStatusByID(String rsvp, Integer id);
    int updateContactByNameAndID(Long contact,String name,Integer id);

    List<String> getAllGuests();
    List<Object[]> getAllGuestsAndContacts();
    List<String> getAllEmail();
}
