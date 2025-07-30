package com.xworkz.household.runner;

import com.xworkz.household.entity.ApplianceEntity;

import javax.persistence.*;

public class ApplianceRead {
    public static void main(String[] args) {
        EntityManagerFactory factory = null;
        EntityManager manager = null;
        EntityTransaction transaction = null;

        try {
            factory = Persistence.createEntityManagerFactory("x-workz");

            manager = factory.createEntityManager();
            ApplianceEntity appliance=manager.find(ApplianceEntity.class,1);
            System.out.println(appliance);

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
