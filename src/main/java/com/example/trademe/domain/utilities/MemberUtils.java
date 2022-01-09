package com.example.trademe.domain.utilities;

import com.example.trademe.domain.enums.Skill;

import java.util.List;
import java.util.Scanner;

public class MemberUtils {
    public static List<Skill> addSkill(Scanner sc, List<Skill> skills) {
        System.out.println("Veuillez choisir une compétence dans la liste : ");
        for(int i=0; i < Skill.values().length; i++){
            System.out.println(i + "." + Skill.values()[i] );
        }
        int userChoice = sc.nextInt();
        sc.nextLine();
        System.out.println(Skill.values()[userChoice]);
        skills.add(Skill.values()[userChoice]);
        return skills;
    }
}
