package com.xworkz.pet_adoption.runner;

import com.xworkz.pet_adoption.entity.PetEntity;

import javax.persistence.*;

public class PetUpdate{
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory=null;
        EntityManager entityManager=null;
        EntityTransaction entityTransaction=null;

        try{
            entityManagerFactory= Persistence.createEntityManagerFactory("x-workz");
            entityManager=entityManagerFactory.createEntityManager();
            entityTransaction=entityManager.getTransaction();

            PetEntity pet=entityManager.find(PetEntity.class,1);
            pet.setColor("yellow");

            entityTransaction.begin();
            entityManager.merge(pet);
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

