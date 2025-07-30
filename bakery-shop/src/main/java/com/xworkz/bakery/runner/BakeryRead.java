package com.xworkz.bakery.runner;

import com.xworkz.bakery.entity.BakedGoodEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

public class BakeryRead {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory=null;
        EntityManager entityManager =null;

        try{
            entityManagerFactory=Persistence.createEntityManagerFactory("x-workz");
            entityManager = entityManagerFactory.createEntityManager();

            BakedGoodEntity entity=entityManager.find(BakedGoodEntity.class,1);
            System.out.println(entity);
        }
        catch(PersistenceException e){
            System.out.println("exception occured");
            System.out.println(e.getMessage());
        }
        finally{
            if(entityManagerFactory!=null){
                entityManagerFactory.close();
            }

            if(entityManager!=null){
                entityManager.close();
            }


        }


    }
}
