package com.pepinho.ad.suzukiviolin;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {

    private static final String PERSISTENCE_UNIT = "suzukilocal";
    private static volatile JPAUtil instance;
    private static volatile EntityManagerFactory emf;

    private JPAUtil() {
    }

    public static JPAUtil getInstance(){
        if (instance == null) {
            synchronized (JPAUtil.class){
                if (instance==null){
                    instance= new JPAUtil();
                }
            }
        }
        return instance;
    }

    public EntityManagerFactory getEntityManagerFactory(){
        if (emf == null || !emf.isOpen()){
            synchronized (JPAUtil.class){
                if (emf==null || !emf.isOpen()){
                    emf= Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
                }
            }
        }
        return emf;
    }
}
