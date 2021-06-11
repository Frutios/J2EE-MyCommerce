package com.formation.mycommerce.dao.jpa;

import com.formation.mycommerce.dao.interfaz.CategoryDao;
import com.formation.mycommerce.entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;

public class JpaCategoryDao implements CategoryDao<Long, Category> {

    private static EntityManagerFactory emf;

    public JpaCategoryDao(EntityManagerFactory entityManagerFactory){
        emf = entityManagerFactory;
    }

    public JpaCategoryDao() {
    }

    @Override
    public Long create(Category category) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        em.persist(category);
        long var=0;
        try{
            et.begin();
            et.commit();
            var = category.getId();
        }catch (RuntimeException e){
            if(et.isActive()){
                et.rollback();
            }
        }finally {
            em.close();
        }
        return var;
    }

    @Override
    public Category findById(Long id) {
        EntityManager em = emf.createEntityManager();
        Category category = em.find(Category.class,id);
        em.close();
        return category;
    }

    @Override
    public List<Category> findAll() {
        EntityManager em = emf.createEntityManager();
        List<Category> list = new ArrayList();
        list = em.createQuery("SELECT a FROM Category a").getResultList();
        return list;
    }

    @Override
    public Boolean update(Category category) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        boolean isUpdated = false;
        try{
            et.begin();
            em.merge(category);
            et.commit();
            isUpdated = true;
        }catch (RuntimeException e){
            if(et.isActive()){
                et.rollback();
            }
        }finally {
            em.close();
        }
        return isUpdated;
    }

    @Override
    public Boolean remove(Long id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        Category category = em.find(Category.class, id);
        boolean isRemoved = false;
        try{
            et.begin();
            em.remove(category);
            et.commit();
            isRemoved = true;
        }catch (RuntimeException e){
            if(et.isActive()){
                et.rollback();
            }
        }finally {
            em.close();
        }
        return isRemoved;
    }
}
