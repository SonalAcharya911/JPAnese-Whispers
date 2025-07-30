package com.xworkz.dmart.runner;

import com.xworkz.dmart.entity.ProductEntity;

import javax.persistence.*;

public class ProductRunner {
    public static void main(String[] args) {

        ProductEntity productEntity= new ProductEntity();
        productEntity.setProductName("soap");
        productEntity.setCompany("Mysore Sandal");
        productEntity.setMfd("11-09-2024");
        productEntity.setPrice(30.00);

        try{
            EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("x-workz");//load,register,connection

            EntityManager entityManager= entityManagerFactory.createEntityManager();//DML(insert, delete, update), DQL(select)

            EntityTransaction transaction=entityManager.getTransaction();//TCL(commit,rollback,savepoint,autocommit)

            transaction.begin();//set autocommit=0;
            entityManager.persist(productEntity);//insert
            transaction.commit();//set autocommit=1;

            entityManager.find(ProductEntity.class,1);
        }
        catch(PersistenceException e){
            System.out.println(e.getMessage());
        }

        System.out.println("success...");




    }
}
