package com.example.trademe.application;

import com.example.trademe.domain.action.CreateMember;
import com.example.trademe.domain.enums.Skill;
import com.example.trademe.domain.id.MemberId;
import com.example.trademe.domain.repository.MemberRepository;

import java.util.List;

public class MemberApplicationService {
    private static MemberRepository memberRepository;

    public MemberApplicationService(MemberRepository memberRepository) {this.memberRepository = memberRepository;}

    public static MemberId create(CreateMember createMember){
        final MemberId memberId = memberRepository.nextIdentity();
        //Member member = new Member(memberId, createMember.firstname, createMember.lastname, createMember.username, createMember.password);
        //memberRepository.add(member);
        return memberId;
    }

    public static void addSkills(List<Skill> skills, MemberId memberId) {
        memberRepository.findById(memberId);
    }
}
