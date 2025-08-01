package com.xworkz.bakery.runner;

import com.xworkz.bakery.entity.BakedGoodEntity;

import javax.persistence.*;

public class BakeryDelete {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory=null;
        EntityManager entityManager=null;
        EntityTransaction entityTransaction=null;

        try{
            entityManagerFactory= Persistence.createEntityManagerFactory("x-workz");
            entityManager=entityManagerFactory.createEntityManager();
            entityTransaction=entityManager.getTransaction();
            entityTransaction.begin();

            BakedGoodEntity bakedGood=entityManager.find(BakedGoodEntity.class,1);

            if(bakedGood!=null){
                entityManager.remove(bakedGood);
                entityTransaction.commit();
            }


        }
        catch(PersistenceException e){
            System.out.println(e.getMessage());
            entityTransaction.rollback();
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
