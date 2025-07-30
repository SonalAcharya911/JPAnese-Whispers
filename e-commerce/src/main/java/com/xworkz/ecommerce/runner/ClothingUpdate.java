package com.xworkz.ecommerce.runner;

import com.xworkz.ecommerce.entity.ClothingEntity;

import javax.persistence.*;

public class ClothingUpdate {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();

            ClothingEntity cloth = entityManager.find(ClothingEntity.class, 1);
            cloth.setClothMaterial("Cotton-mix");
            entityTransaction.begin();
            entityManager.merge(cloth);
            entityTransaction.commit();

        } catch (PersistenceException e) {
            System.out.println(e.getMessage());
        } finally {
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }
}
