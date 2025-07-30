package com.xworkz.ecommerce.runner;

import com.xworkz.ecommerce.entity.FootwearEntity;

import javax.persistence.*;

public class FootwearUpdate {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory=null;
        EntityManager entityManager=null;
        EntityTransaction entityTransaction=null;

        try{
            entityManagerFactory= Persistence.createEntityManagerFactory("x-workz");
            entityManager=entityManagerFactory.createEntityManager();
            entityTransaction=entityManager.getTransaction();

            FootwearEntity footwear=entityManager.find(FootwearEntity.class,1);
            footwear.setPrice(300.00);

            entityTransaction.begin();
            entityManager.merge(footwear);
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
