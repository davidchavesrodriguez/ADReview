package com.pepinho.ad.suzukiviolin;

import com.pepinho.ad.suzukiviolin.entities.Autor;
import jakarta.persistence.EntityManager;

import java.time.LocalDate;

public class AppSuzuki {
    public static void main(String[] args) {
        EMFManager emfManager = EMFManager.getInstance("suzukilocal");
        EntityManager entityManager = emfManager.getEntityManagerFactory().createEntityManager();

        try {
            Autor author = new Autor("Shinichi", "Suzuki", "JPN", null, LocalDate.now());
            author.setIdAutor(42L);

            entityManager.getTransaction().begin();
            entityManager.persist(author);
            entityManager.getTransaction().commit();

            System.out.println("New Author: " + author);
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }
}