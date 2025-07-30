package com.xworkz.household.runner;

import com.xworkz.household.entity.FurnitureEntity;

import javax.persistence.*;

public class FurnitureRead {
    public static void main(String[] args) {
        EntityManagerFactory factory = null;
        EntityManager manager = null;
        EntityTransaction transaction = null;

        try {
            factory = Persistence.createEntityManagerFactory("x-workz");

            manager = factory.createEntityManager();
            FurnitureEntity furniture=manager.find(FurnitureEntity.class,1);
            System.out.println(furniture);

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
