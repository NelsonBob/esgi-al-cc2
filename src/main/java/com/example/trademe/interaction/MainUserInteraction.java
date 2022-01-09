package com.example.trademe.interaction;

import java.util.Scanner;

public interface MainUserInteraction {
    static int firstMenu(Scanner sc ) {

        System.out.println("Bienvenue sur Trade Me, ");
        System.out.println("1. Je suis un membre. ");
        System.out.println("2. Je suis un préstataire. ");
        System.out.println("Veuillez choisir une option : ");
        sc.nextInt();

        return sc.nextInt();
    }
}
