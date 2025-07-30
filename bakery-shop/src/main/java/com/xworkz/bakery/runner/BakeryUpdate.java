package com.xworkz.bakery.runner;

import com.xworkz.bakery.entity.BakedGoodEntity;

import javax.persistence.*;

public class BakeryUpdate {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory=null;
        EntityManager entityManager=null;
        EntityTransaction entityTransaction=null;

        try{
            entityManagerFactory= Persistence.createEntityManagerFactory("x-workz");
            entityManager=entityManagerFactory.createEntityManager();
            entityTransaction=entityManager.getTransaction();

            entityTransaction.begin();
            BakedGoodEntity bakedGood= entityManager.find(BakedGoodEntity.class,2);
            System.out.println(bakedGood);
            bakedGood.setMadeOf("Maida");
            System.out.println(bakedGood);

            entityManager.merge(bakedGood);
            System.out.println(bakedGood);
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
