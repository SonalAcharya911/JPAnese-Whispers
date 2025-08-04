package com.xworkz.guest.repo;

import com.xworkz.guest.entity.GuestEntity;
import com.xworkz.guest.service.GuestService;

import javax.persistence.*;

public class GuestRepoImpl implements GuestRepo{

    private EntityManagerFactory emf= Persistence.createEntityManagerFactory("x-workz");
    private EntityManager em;
    private EntityTransaction transaction;

    @Override
    public boolean save(GuestEntity guestEntity) {
        if(guestEntity!=null){
            try{
                em=emf.createEntityManager();
                transaction= em.getTransaction();

                transaction.begin();
                em.persist(guestEntity);
                transaction.commit();
            }
            catch(PersistenceException e){
                System.out.println(e.getMessage());
                transaction.rollback();
            }
            finally{
                if(emf!=null){
                    emf.close();
                }
                if(em!=null){
                    em.close();
                }
            }

            return true;
        }
        return false;
    }

    @Override
    public boolean deleteGuestByName(String name) {
        if(name!=null){
            try{
                em=emf.createEntityManager();
                transaction= em.getTransaction();

                transaction.begin();
                GuestEntity entity=em.find(GuestEntity.class,name);
                em.remove(entity);

                transaction.commit();
            }
            catch(PersistenceException e){
                System.out.println(e.getMessage());
                transaction.rollback();
            }
            finally{
                if(emf!=null){
                    emf.close();
                }
                if(em!=null){
                    em.close();
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public void updateGuestName(int id, String oldName, String newName) {
        if(id!=0 && oldName!=null ) {
            try {
                em = emf.createEntityManager();
                transaction = em.getTransaction();

                transaction.begin();
                GuestEntity entity = em.find(GuestEntity.class, oldName);
                entity.setGuestName(newName);
                em.merge(entity);

                transaction.commit();
            } catch (PersistenceException e) {
                System.out.println(e.getMessage());
                transaction.rollback();
            } finally {
                if (emf != null) {
                    emf.close();
                }
                if (em != null) {
                    em.close();
                }
            }
        }
    }

    @Override
    public GuestEntity findByID(int id) {
        GuestEntity entity=null;
        if(id!=0){

            try{
                em=emf.createEntityManager();

                entity=em.find(GuestEntity.class,id);
            }
            catch(PersistenceException e){
                System.out.println(e.getMessage());

            }
            finally{
                if(emf!=null){
                    emf.close();
                }
                if(em!=null){
                    em.close();
                }
            }
        }
        else{
            System.out.println("no value found");

        }
        return entity;
    }

    @Override
    public GuestEntity findByName(String name) {
        GuestEntity entity=null;
        if(name!=null){

            try{
                em=emf.createEntityManager();
                entity=em.find(GuestEntity.class,name);
            }
            catch(PersistenceException e){
                System.out.println(e.getMessage());
            }
            finally{
                if(emf!=null){
                    emf.close();
                }
                if(em!=null){
                    em.close();
                }
            }
        }
        else{
            System.out.println("no value found");

        }
        return entity;

    }

    @Override
    public GuestEntity findByContact(Long contact) {
        GuestEntity entity=null;
        if(contact!=0){

            try{
                em=emf.createEntityManager();

                entity=em.find(GuestEntity.class,contact);
            }
            catch(PersistenceException e){
                System.out.println(e.getMessage());
            }
            finally{
                if(emf!=null){
                    emf.close();
                }
                if(em!=null){
                    em.close();
                }
            }
        }
        else{
            System.out.println("no value found");

        }
        return entity;
    }

    @Override
    public GuestEntity findByEmail(String email) {
        GuestEntity entity=null;
        if(email!=null){

            try{
                em=emf.createEntityManager();

                entity=em.find(GuestEntity.class,email);
            }
            catch(PersistenceException e){
                System.out.println(e.getMessage());
                transaction.rollback();
            }
            finally{
                if(emf!=null){
                    emf.close();
                }
                if(em!=null){
                    em.close();
                }
            }
        }
        else{
            System.out.println("no value found");

        }
        return entity;
    }
}
