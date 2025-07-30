package com.xworkz.household.runner;

import com.xworkz.household.entity.ApplianceEntity;
import com.xworkz.household.entity.FurnitureEntity;

import javax.persistence.*;

public class HouseHoldItemCreate {
    public static void main(String[] args) {
        ApplianceEntity applianceEntity=new ApplianceEntity(0,"Godrej Front load","Washing Machine","Godrej",450,12);
        FurnitureEntity furnitureEntity=new FurnitureEntity(0,"Brown 8 member Dining Table",10000.00,"Wood","Brown",'L');

        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        try{
            entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");

            entityManager = entityManagerFactory.createEntityManager();

            transaction = entityManager.getTransaction();

            transaction.begin();
//            entityManager.persist(applianceEntity);
            entityManager.persist(furnitureEntity);
            transaction.commit();
        }
        catch(PersistenceException e)
        {
            System.out.println(e.getMessage());
            e.printStackTrace();
            transaction.rollback();
        }
        finally{

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
