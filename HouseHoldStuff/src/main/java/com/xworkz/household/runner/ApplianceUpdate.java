package com.xworkz.household.runner;

import com.xworkz.household.entity.ApplianceEntity;

import javax.persistence.*;

public class ApplianceUpdate {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory=null;
        EntityManager entityManager=null;
        EntityTransaction entityTransaction=null;

        try{
            entityManagerFactory= Persistence.createEntityManagerFactory("x-workz");
            entityManager=entityManagerFactory.createEntityManager();
            entityTransaction=entityManager.getTransaction();

            ApplianceEntity appliance=entityManager.find(ApplianceEntity.class,1);
            appliance.setWarranty(32);

            entityTransaction.begin();
            entityManager.merge(appliance);
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
