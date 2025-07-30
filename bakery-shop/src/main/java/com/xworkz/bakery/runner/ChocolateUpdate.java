package com.xworkz.bakery.runner;

import com.xworkz.bakery.entity.ChocolateEntity;

import javax.persistence.*;

public class ChocolateUpdate {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory=null;
        EntityManager entityManager=null;
        EntityTransaction entityTransaction=null;

        try{
            entityManagerFactory= Persistence.createEntityManagerFactory("x-workz");
            entityManager=entityManagerFactory.createEntityManager();
            entityTransaction=entityManager.getTransaction();

            ChocolateEntity chocolate= entityManager.find(ChocolateEntity.class,2);

            entityTransaction.begin();

            chocolate.setChocolatePrice(5.0);
            entityManager.merge(chocolate);
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
