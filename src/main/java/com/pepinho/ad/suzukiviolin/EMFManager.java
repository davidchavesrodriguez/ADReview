package com.pepinho.ad.suzukiviolin;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Map;

public class EMFManager {
    private static volatile EMFManager instance;
    private EntityManagerFactory entityManagerFactory;

    // TODO: Manage multiple persistence units
    private Map<String, EntityManagerFactory> factories;

    private EMFManager(String persistenceUnit) {
        this.entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnit);
    }

    // Singleton
    public static EMFManager getInstance(String persistenceUnit) {
        if (instance == null) {
            synchronized (EMFManager.class) {
                if (instance == null) {
                    instance = new EMFManager(persistenceUnit);
                }
            }
        }
        return instance;
    }

    public EntityManagerFactory getEntityManagerFactory() {
        if (entityManagerFactory == null || !entityManagerFactory.isOpen()) {
            throw new IllegalStateException("EntityManagerFactory not initialized or closed");
        }
        return entityManagerFactory;
    }

    public void close() {
        if (entityManagerFactory != null && entityManagerFactory.isOpen()) {
            entityManagerFactory.close();
        }
    }

    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

}