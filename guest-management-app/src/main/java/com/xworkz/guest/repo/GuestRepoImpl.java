package com.xworkz.guest.repo;

import com.xworkz.guest.entity.GuestEntity;
import com.xworkz.guest.service.GuestService;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

public class GuestRepoImpl implements GuestRepo{

    private static final EntityManagerFactory emf= Persistence.createEntityManagerFactory("x-workz");
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
                e.printStackTrace();
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

                GuestEntity entity= (GuestEntity) em.createQuery("select g from GuestEntity g where g.guestName=: name").setParameter("name",name).getSingleResult();
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
                GuestEntity entity = em.find(GuestEntity.class, id);
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
                entity= (GuestEntity) em.createNamedQuery("findByName").setParameter("name",name).getSingleResult();
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
                entity= (GuestEntity) em.createNamedQuery("findByContact").setParameter("contact",contact).getSingleResult();
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
                entity= (GuestEntity) em.createNamedQuery("findByEmail").setParameter("email",email).getSingleResult();

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

    @Override
    public int updateEmailByName(String email, String name) {
        EntityManager em=null;
        EntityTransaction et=null;
        int rows=0;
        try{
            em=emf.createEntityManager();
            et=em.getTransaction();

            et.begin();
            Query query=em.createNamedQuery("updateEmailByName").setParameter("email",email).setParameter("guestName",name);
            rows=query.executeUpdate();
            et.commit();
        }
        catch(PersistenceException e){
            System.out.println(e.getMessage());
            et.rollback();
        }
        finally{
            if(em!=null){
                em.close();
            }
        }
        return rows;
    }

    @Override
    public int updateRsvpStatusByID(String rsvp, Integer id) {
        EntityManager em=null;
        EntityTransaction et=null;
        int rows=0;
        try{
            em=emf.createEntityManager();
            et=em.getTransaction();

            et.begin();
            Query query=em.createNamedQuery("updateRsvpStatusByID").setParameter("rsvp",rsvp).setParameter("id",id);
            rows=query.executeUpdate();
            et.commit();
        }
        catch(PersistenceException e){
            System.out.println(e.getMessage());
            et.rollback();
        }
        finally{
            if(em!=null){
                em.close();
            }
        }
        return rows;
    }

    @Override
    public int updateContactByNameAndID(Long contact, String name, Integer id) {
        EntityManager em=null;
        EntityTransaction et=null;
        int rows=0;
        try{
            em=emf.createEntityManager();
            et=em.getTransaction();

            et.begin();
            Query query=em.createNamedQuery("updateContactByNameAndID").setParameter("contact",contact).setParameter("id",id).setParameter("guestName",name);
            rows=query.executeUpdate();
            et.commit();
        }
        catch(PersistenceException e){
            System.out.println(e.getMessage());
            et.rollback();
        }
        finally{
            if(em!=null){
                em.close();
            }
        }
        return rows;
    }

    @Override
    public List<String> getAllGuests() {
        List<String> guestNames=null;
        EntityManager em=null;
        try{
            em=emf.createEntityManager();
            guestNames=em.createNamedQuery("getAllGuests").getResultList();
        }catch(PersistenceException e){
            System.out.println(e.getMessage());
        }finally {
            if(em!=null){
                em.close();
            }
        }
        return guestNames;
    }

    @Override
    public List<Object[]> getAllGuestsAndContacts() {
        List<Object[]> list=null;
        EntityManager em=null;
        try{
            em=emf.createEntityManager();
            list=em.createNamedQuery("getAllGuestsAndContacts").getResultList();
        }catch(PersistenceException e){
            System.out.println(e.getMessage());
        }finally {
            if(em!=null){
                em.close();
            }
        }
        return list;
    }

    @Override
    public List<String> getAllEmail() {
        List<String> email=null;
        EntityManager em=null;
        try{
            em=emf.createEntityManager();
            email=em.createNamedQuery("getAllWardNos").getResultList();
        }catch(PersistenceException e){
            System.out.println(e.getMessage());
        }finally {
            if(em!=null){
                em.close();
            }
        }
        return email;
    }

    public void closeFactory(){
        if(emf!=null && emf.isOpen()){
            emf.close();
        }
    }
}
