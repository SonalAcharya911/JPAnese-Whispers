package com.xworkz.pet_adoption.runner;

import com.xworkz.pet_adoption.entity.OwnerEntity;
import com.xworkz.pet_adoption.entity.PetEntity;

import javax.persistence.*;

public class PetAdoptionRead {
    public static void main(String[] args) {
        EntityManagerFactory factory = null;
        EntityManager manager = null;
        EntityTransaction transaction = null;

        try {
            factory = Persistence.createEntityManagerFactory("x-workz");

            manager = factory.createEntityManager();
            OwnerEntity owner=manager.find(OwnerEntity.class,1);
            PetEntity pet=manager.find(PetEntity.class,1);

        } catch (PersistenceException e) {
            System.out.println(e.getMessage());
        } finally {
            if (factory != null) {
                factory.close();
            }
            if (manager != null) {
                manager.close();
            }
        }
    }
}
