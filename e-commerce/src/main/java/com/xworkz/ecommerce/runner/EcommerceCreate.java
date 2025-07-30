package com.xworkz.ecommerce.runner;

import com.xworkz.ecommerce.entity.ClothingEntity;
import com.xworkz.ecommerce.entity.FootwearEntity;

import javax.persistence.*;

public class EcommerceCreate {
    public static void main(String[] args) {
        ClothingEntity clothingEntity=new ClothingEntity(0,"tunic","HotPink","Cotton",350.00,10);
        FootwearEntity footwearEntity=new FootwearEntity(0,"Sandals","Bata","Black",520.00,"Leather");

        EntityManagerFactory entityManagerFactory = null;//costly resource
        EntityManager entityManager = null;//costly resource
        EntityTransaction transaction = null;

        try{
            entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");

            entityManager = entityManagerFactory.createEntityManager();

            transaction = entityManager.getTransaction();

            transaction.begin();
            entityManager.persist(clothingEntity);
            entityManager.persist(footwearEntity);

            transaction.commit();
        }
        catch(
                PersistenceException e)

        {
            System.out.println(e.getMessage());
            e.printStackTrace();
            transaction.rollback();
        }
        finally

        {

            if (entityManagerFactory != null) {
                entityManagerFactory.close();
                System.out.println("entity manager factory closed..");
            }
            if (entityManager != null) {
                entityManager.close();
                System.out.println("entity manager closed..");
            }
        }
    }
}
