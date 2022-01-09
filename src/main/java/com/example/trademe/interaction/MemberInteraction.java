package com.example.trademe.interaction;

import com.example.trademe.domain.action.CreateMember;
import com.example.trademe.domain.dto.LoginUserDto;

import java.util.Scanner;

public interface MemberInteraction {

    static int firstMenu(Scanner sc) {
        System.out.println("Bonjour, ");
        System.out.println("0. Inscription ");
        System.out.println("1. Connexion ");

        return sc.nextInt();
    }

    static CreateMember inscriptionMenu(Scanner sc) {
        System.out.println("Veuillez entrer votre prénom :");
        String firstname = sc.nextLine();
        System.out.println("Veuillez entrer votre nom :");
        String lastname = sc.nextLine();
        System.out.println("Veuillez entrer votre nom d'utilisateur :");
        String username = sc.nextLine();
        System.out.println("Veuillez entrer votre mot de passe :");
        String password = sc.nextLine();

        //TODO ajouter une vérification des paramètres

        return new CreateMember(firstname, lastname, username, password);
    }

    static LoginUserDto connectionMenu(Scanner sc) {
        System.out.println("Veuillez entrer votre nom d'utilisateur :");
        String username = sc.nextLine();
        System.out.println("Veuillez entrer votre mot de passe :");
        String password = sc.nextLine();
        return new LoginUserDto(username, password);
    }

    static int secondMenu(Scanner sc) {
        System.out.println("Veuillez choisir une option : ");
        System.out.println("0. Mes compétences  ");
        System.out.println("1. Mes zones de disponibilité ");
        System.out.println("2. Mes taches ");
        return sc.nextInt();
    }
}

