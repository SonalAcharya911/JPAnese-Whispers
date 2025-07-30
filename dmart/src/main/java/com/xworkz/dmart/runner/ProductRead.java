package com.xworkz.dmart.runner;

import com.xworkz.dmart.entity.ProductEntity;

import javax.persistence.*;

public class ProductRead {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory=null;
        EntityManager entityManager=null;

        try{
            entityManagerFactory= Persistence.createEntityManagerFactory("x-workz");

            entityManager= entityManagerFactory.createEntityManager();

            ProductEntity entity=entityManager.find(ProductEntity.class,4);
            System.out.println(entity);
        }
        catch(PersistenceException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
