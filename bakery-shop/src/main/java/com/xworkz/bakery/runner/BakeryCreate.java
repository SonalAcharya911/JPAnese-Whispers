package com.xworkz.bakery.runner;

import com.xworkz.bakery.entity.BakedGoodEntity;
import com.xworkz.bakery.entity.ChocolateEntity;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

public class BakeryCreate {
    public static void main(String[] args) {
        BakedGoodEntity bakedGoodEntity=new BakedGoodEntity(0,"bread","milk-bread","wheat", Date.valueOf(LocalDate.of(2025,7,11)),Date.valueOf(LocalDate.of(2025,7,30)));

        ChocolateEntity chocolateEntity=new ChocolateEntity();
        chocolateEntity.setChocolateName("Dairy Milk");
        chocolateEntity.setChocolateType("Milk Chocolate");
        chocolateEntity.setBrand("Cadbury");
        chocolateEntity.setExpiryDate(Date.valueOf(LocalDate.of(2025,9,7)));
        chocolateEntity.setNumOfChocolates(2);
        chocolateEntity.setChocolatePrice(20.00);

        EntityManagerFactory entityManagerFactory = null; //costly resource
        EntityManager entityManager = null; //costly resource
        EntityTransaction transaction = null;

        try{
            entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");// load and register

            entityManager = entityManagerFactory.createEntityManager();// DML(insert, update, delete), DQL(select)

            transaction = entityManager.getTransaction();//TCL(commit,rollback,autocommmit, savepoint)

            transaction.begin(); //set autocommit=0
            entityManager.persist(bakedGoodEntity); //insert
            entityManager.persist(chocolateEntity); //insert
            transaction.commit(); //set autocommit=1;
        }
        catch(PersistenceException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            transaction.rollback();
        }
        finally{ //closing costly resources
            if (entityManagerFactory != null) { //close only if resource is used
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
