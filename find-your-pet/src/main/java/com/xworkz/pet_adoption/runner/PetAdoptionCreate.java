package com.xworkz.pet_adoption.runner;

import com.xworkz.pet_adoption.entity.OwnerEntity;
import com.xworkz.pet_adoption.entity.PetEntity;

import javax.persistence.*;

public class PetAdoptionCreate {
    public static void main(String[] args) {
        OwnerEntity ownerEntity=new OwnerEntity(0,"Sonal","sonalvinodkarma@gmail.com",7483452103l,"Brookefield");
        PetEntity pet=new PetEntity(0,"Bird","Budgie",1,"blue","millets",10);

        EntityManagerFactory entityManagerFactory = null;//costly resource
        EntityManager entityManager = null;//costly resource
        EntityTransaction transaction = null;

        try{
            entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");

            entityManager = entityManagerFactory.createEntityManager();

            transaction = entityManager.getTransaction();

            transaction.begin();
            entityManager.persist(ownerEntity);
            entityManager.persist(pet);
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
