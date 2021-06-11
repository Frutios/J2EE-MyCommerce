package com.formation.mycommerce.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceManager {
    private static EntityManagerFactory emf;

    private PersistenceManager(){
        //Private constructor prevent instantiation
    }


    // Lazy initialization
    public static EntityManagerFactory getConnectionEntityManagerFactory(){
        if(emf == null){
            emf = Persistence.createEntityManagerFactory("PU");
        }

        return emf;
    }

    //close
    public static void closeEntityManagerFactory(){

        if(emf != null && emf.isOpen()) emf.close();
    }
}