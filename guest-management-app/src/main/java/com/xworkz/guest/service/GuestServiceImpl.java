package com.xworkz.guest.service;

import com.xworkz.guest.entity.GuestEntity;
import com.xworkz.guest.repo.GuestRepo;

import javax.persistence.EntityManager;

public class GuestServiceImpl implements GuestService{
    private GuestRepo guestRepo;
    private EntityManager em;


    @Override
    public boolean save(GuestEntity guestEntity) {
        if(guestEntity!=null){
            if(guestEntity.getGuestName()!=null && guestEntity.getGuestName().length()<3){
                System.out.println("valid name");
            }
            else{
                System.out.println("invalid name");
                return false;
            }
            if(guestEntity.getEmail()!=null && guestEntity.getEmail().endsWith(".com")){
                System.out.println("valid email");
            }
            else{
                System.out.println("invalid email");
                return false;
            }
            if(guestEntity.getContactNumber()!=0 && guestEntity.getContactNumber()<1000000000l){
                System.out.println("valid contact");
            }
            else {
                System.out.println("invalid email");
                return false;
            }
            String rsvp= guestEntity.getRsvpStatus();
            if (rsvp!=null && (rsvp.toLowerCase().equals("yes") || rsvp.toLowerCase().equals("no") || rsvp.toLowerCase().equals("may be"))){
                System.out.println("valid rsvp");
            }
            else{
                System.out.println("invalid rsvp");
                return false;
            }
            String foodPreference= guestEntity.getFoodPreference();
            if(foodPreference!=null && (foodPreference.toLowerCase().equals("veg") || foodPreference.toLowerCase().equals("non-veg"))){
                System.out.println("valid preference");
            }
            else{
                System.out.println("invalid preference");
                return false;
            }


            System.out.println("validation done");

            boolean saved=guestRepo.save(guestEntity);
            if(saved){
                System.out.println("saved to repo");
            }
            else{
                System.out.println("couldn't save guest data to repo");
                return false;
            }

            return true;
        }
        return false;

    }

    @Override
    public boolean deleteGuestByName(String name) {
        if(name!=null){
            boolean deleted=guestRepo.deleteGuestByName(name);
            if(deleted){
                System.out.println("deleted data");
                return true;
            }
            else{
                System.out.println("could'nt delete data");
            }
        }
        return false;
    }

    @Override
    public void updateGuestName(int id, String oldName, String newName) {
        guestRepo.updateGuestName(id,oldName,newName);
    }

    @Override
    public GuestEntity findByID(int id) {

        GuestEntity entity=null;
        if(id!=0){
            entity=guestRepo.findByID(id);
        }

        return entity;
    }

    @Override
    public GuestEntity findByName(String name) {
        if(name!=null){
            GuestEntity entity=guestRepo.findByName(name);
            return entity;
        }
        return null;
    }

    @Override
    public GuestEntity findByContact(Long contact) {
        if(contact!=null){
            GuestEntity entity=guestRepo.findByContact(contact);
            return entity;
        }
        return null;
    }

    @Override
    public GuestEntity findByEmail(String email) {
        if(email!=null){
            GuestEntity entity=guestRepo.findByEmail(email);
            return entity;
        }
        return null;
    }
}
