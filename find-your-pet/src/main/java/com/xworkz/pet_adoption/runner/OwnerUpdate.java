package com.xworkz.pet_adoption.runner;

import com.xworkz.pet_adoption.entity.OwnerEntity;

import javax.persistence.*;

public class OwnerUpdate {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory=null;
        EntityManager entityManager=null;
        EntityTransaction entityTransaction=null;

        try{
            entityManagerFactory= Persistence.createEntityManagerFactory("x-workz");
            entityManager=entityManagerFactory.createEntityManager();
            entityTransaction=entityManager.getTransaction();

            OwnerEntity owner=entityManager.find(OwnerEntity.class,1);
            owner.setContact(9740126919l);

            entityTransaction.begin();
            entityManager.merge(owner);
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
