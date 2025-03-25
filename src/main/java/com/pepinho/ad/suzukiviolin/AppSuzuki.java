package com.pepinho.ad.suzukiviolin;

import com.pepinho.ad.suzukiviolin.entities.*;
import jakarta.persistence.EntityManager;

import java.time.LocalDate;

public class AppSuzuki {
    public static void main(String[] args) {

        DirectorSingleton director = DirectorSingleton.getInstance("Pepe", "Calo", "pepecalo@gmail.com", 23);
        DirectorSingleton director2 = DirectorSingleton.getInstance("Pepe", "Calo", "pepecalo@gmail.com", 23);

        if (director2 == director) {
            System.out.println("Teño un director");
        } else {
            System.out.println("Son dous");
        }
    }
}
