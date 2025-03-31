package com.pepinho.ad.suzukiviolin;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

public class EMFManager {
    private static volatile EMFManager instance;
    private final Map<String, EntityManagerFactory> factories;
    private final Object lock = new Object();

    private EMFManager() {
        this.factories = Collections.synchronizedMap(new HashMap<>());
    }

    // Singleton
    public static EMFManager getInstance() {
        if (instance == null) {
            synchronized (EMFManager.class) {
                if (instance == null) {
                    instance = new EMFManager();
                }
            }
        }
        return instance;
    }

    public EntityManagerFactory getEntityManagerFactory(String persistenceUnit) {
        synchronized (lock) {
            if (!factories.containsKey(persistenceUnit) ||
                    factories.get(persistenceUnit) == null ||
                    !factories.get(persistenceUnit).isOpen()) {

                EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnit);
                factories.put(persistenceUnit, emf);
            }
            return factories.get(persistenceUnit);
        }
    }

    public void close(String persistenceUnit) {
        synchronized (lock) {
            EntityManagerFactory emf = factories.get(persistenceUnit);
            if (emf != null && emf.isOpen()) {
                emf.close();
                factories.remove(persistenceUnit);
            }
        }
    }

    public void closeAll() {
        synchronized (lock) {
            factories.forEach((unit, emf) -> {
                if (emf != null && emf.isOpen()) {
                    emf.close();
                }
            });
            factories.clear();
        }
    }

    public EntityManager createEntityManager(String persistenceUnit) {
        return getEntityManagerFactory(persistenceUnit).createEntityManager();
    }

    public boolean containsPersistenceUnit(String persistenceUnit) {
        return factories.containsKey(persistenceUnit);
    }
}