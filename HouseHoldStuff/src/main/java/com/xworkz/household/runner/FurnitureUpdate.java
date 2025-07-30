package com.xworkz.household.runner;

import com.xworkz.household.entity.FurnitureEntity;

import javax.persistence.*;

public class FurnitureUpdate {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory=null;
        EntityManager entityManager=null;
        EntityTransaction entityTransaction=null;

        try{
            entityManagerFactory= Persistence.createEntityManagerFactory("x-workz");
            entityManager=entityManagerFactory.createEntityManager();
            entityTransaction=entityManager.getTransaction();

            FurnitureEntity furnitureEntity=entityManager.find(FurnitureEntity.class,1);
            furnitureEntity.setPrice(10200);

            entityTransaction.begin();
            entityManager.merge(furnitureEntity);
            entityTransaction.commit();

        }
        catch(PersistenceException e){
            System.out.println(e.getMessage());
        }
        finally {
            if(entityManagerFactory!=null){
                entityManagerFactory.close();
            }
            if(entityManager!=null){
                entityManager.close();
            }
        }
    }
}
