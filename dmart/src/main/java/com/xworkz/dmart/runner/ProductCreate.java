package com.xworkz.dmart.runner;

import com.xworkz.dmart.entity.ProductEntity;

import javax.persistence.*;

public class ProductCreate {
    public static void main(String[] args) {

        ProductEntity productEntity= new ProductEntity();

        productEntity.setProductName("Mango");
        productEntity.setCompany("FTH");
        productEntity.setMfd("29-07-2025");
        productEntity.setPrice(30.00);

        System.out.println(productEntity);

        EntityManagerFactory entityManagerFactory=null;//costly resource
        EntityManager entityManager=null;//costly resource
        EntityTransaction transaction=null;

        try{
            entityManagerFactory= Persistence.createEntityManagerFactory("x-workz");

            entityManager= entityManagerFactory.createEntityManager();

            transaction=entityManager.getTransaction();

            transaction.begin();//set autocommit=0;
            entityManager.persist(productEntity);//insert
            transaction.commit();//set autocommit=1;
        }
        catch(PersistenceException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            transaction.rollback();

        }
        finally {

            if(entityManagerFactory!=null){
                entityManagerFactory.close();
                System.out.println("entity manager factory closed..");
            }
            if(entityManager!=null){
                entityManager.close();
                System.out.println("entity manager closed..");
            }
        }

        System.out.println("success...");

    }
}
