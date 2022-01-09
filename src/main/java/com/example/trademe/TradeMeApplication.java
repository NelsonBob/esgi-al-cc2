package com.example.trademe;

import com.example.trademe.application.controller.MemberApplicationController;
import com.example.trademe.domain.action.CreateMember;
import com.example.trademe.domain.dto.LoginUserDto;
import com.example.trademe.domain.id.MemberId;
import com.example.trademe.interaction.MainUserInteraction;
import com.example.trademe.interaction.MemberInteraction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class TradeMeApplication {

    /*public static void main(String[] args) {
        SpringApplication.run(TradeMeApplication.class, args);
    } */
    public static void main(String[] args) {
        final ConfigurableApplicationContext applicationContext = SpringApplication.run(TradeMeApplication.class, args);

        Scanner sc = new Scanner(System.in);

        //Menu principal pour déterminer le type d'utilisateur (member ou contractor)
        int userChoice = MainUserInteraction.firstMenu(sc);

        //L'utilisateur est un membre (ouvrier)
        if(userChoice==0){
            userChoice = MemberInteraction.firstMenu(sc);

            //Initialisation du membre en cours d'utilisation de l'application
            MemberId memberId = null;

            //Inscription ou connexion au portail Membre
            if(userChoice==0){
                CreateMember createdMember = MemberInteraction.inscriptionMenu(sc);
                memberId = MemberApplicationController.create(createdMember);
            } else {
                LoginUserDto userToConect = MemberInteraction.connectionMenu(sc);
                memberId = MemberApplicationController.getMember(userToConect).getId();
            }

            //Une fois connecté l'utilisateur peut ajouter des compétences
            userChoice = MemberInteraction.secondMenu(sc);

            if(userChoice==0)
                MemberApplicationController.updateMemberWithSkills(sc, memberId);
        }

    }

}
