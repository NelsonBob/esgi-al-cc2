package com.example.trademe.application.controller;

import com.example.trademe.application.MemberApplicationService;
import com.example.trademe.domain.Member;
import com.example.trademe.domain.action.CreateMember;
import com.example.trademe.domain.dto.LoginUserDto;
import com.example.trademe.domain.enums.Skill;
import com.example.trademe.domain.id.MemberId;
import com.example.trademe.domain.repository.MemberRepository;
import com.example.trademe.domain.utilities.MemberUtils;
import com.example.trademe.infrastructure.InMemoryMemberRepository;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
@Controller
public class MemberApplicationController {
    public static MemberId create(CreateMember createMember){
        MemberRepository memberRepository = new InMemoryMemberRepository();
        MemberApplicationService memberApplicationService = new MemberApplicationService(memberRepository);
        final MemberId memberId = memberApplicationService.create(createMember);
        final Optional<Member> storedMember = Optional.ofNullable(memberRepository.findById(memberId));
        if(storedMember.isPresent()){
            System.out.println("Bienvenue sur Trade Me : " + storedMember.get().getFirstname() + " " + storedMember.get().getLastname());
            return storedMember.get().getId();
        }
        return null;
    }

    public static Member getMember(LoginUserDto userToConect) {
        MemberRepository memberRepository = new InMemoryMemberRepository();
        MemberApplicationService memberApplicationService = new MemberApplicationService(memberRepository);
        return memberRepository.findByUsernameAndPassword(userToConect.getUsername(), userToConect.getPassword());
    }

    public static void addSkills(List<Skill> skills, MemberId memberId) {
        MemberRepository memberRepository = new InMemoryMemberRepository();
        MemberApplicationService memberApplicationService = new MemberApplicationService(memberRepository);
        final Member member = memberRepository.findById(memberId);
        //member.setSkills(skills);
        if(member.isPresent()){
            memberRepository.add(Optional.of(member));
            member.toString();
        }
    }


    public static void updateMemberWithSkills(Scanner sc, MemberId memberId) {
        sc.nextLine();
        List<Skill> skills = new ArrayList<>();
        MemberUtils.addSkill(sc, skills);
        int userChoice;
        System.out.println("Voulez vous ajouter une autre compétence ? ");
        System.out.println("0. Oui ");
        System.out.println("1. Non ");
        userChoice = sc.nextInt();
        //TODO reprendre la réitération de l'action
        if(userChoice==0){
            MemberUtils.addSkill(sc, skills);
        }
        MemberApplicationController.addSkills(skills, memberId);
    }
}
