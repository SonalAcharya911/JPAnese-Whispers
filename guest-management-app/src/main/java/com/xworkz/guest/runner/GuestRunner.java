package com.xworkz.guest.runner;

import com.xworkz.guest.entity.GuestEntity;
import com.xworkz.guest.service.GuestService;
import com.xworkz.guest.service.GuestServiceImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class GuestRunner {
    public static void main(String[] args) {
        GuestEntity entity1=new GuestEntity(0,"Tony Stark",9874563210l,"anthonystark.3000@gmail.com","yes","non-veg");
        GuestEntity entity2=new GuestEntity(0,"Natasha Romanoff",7895654123l,"natalia@gmail.com","may be","veg");
        GuestEntity entity3=new GuestEntity(0,"Bruce Banner",7412589630L,"hulkbanner@gmail.com","no","veg");
        GuestEntity entity4=new GuestEntity(0,"Steve Rogers",3692581447L,"steve.1945@gmail.com","yes","veg");
        GuestEntity entity5=new GuestEntity(0,"Clint Barton",75395182640l,"ronin.2023@gmail.com","yes","non-veg");
        GuestEntity entity6=new GuestEntity(0,"Thor Odinson",1234567890l,"pointbreak@gmail.com","may be","non-veg");

        //saving data
        GuestService service=new GuestServiceImpl();
        service.save(entity1);
        service.save(entity2);
        service.save(entity3);
        service.save(entity4);
        service.save(entity5);
        service.save(entity6);

        service.deleteGuestByName("Bruce Banner");

        service.updateGuestName(1,"Tony Stark","Anthony Howard Stark");

        service.findByContact(75395182640l);

        service.findByName("CLint Barton");

        service.findByEmail("pointbreak@gmail.com");

        service.findByID(4);

    }
}
