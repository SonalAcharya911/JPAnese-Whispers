package com.xworkz.ecommerce.runner;

import com.xworkz.ecommerce.entity.ClothingEntity;
import com.xworkz.ecommerce.entity.FootwearEntity;

import javax.persistence.*;

public class ECommerceProductRead {
    public static void main(String[] args) {
        EntityManagerFactory factory = null;
        EntityManager manager = null;
        EntityTransaction transaction = null;

        try {
            factory = Persistence.createEntityManagerFactory("x-workz");

            manager = factory.createEntityManager();
            ClothingEntity clothing=manager.find(ClothingEntity.class,1);
            FootwearEntity footwearEntity=manager.find(FootwearEntity.class,1);
            System.out.println(clothing);
            System.out.println(footwearEntity);

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
