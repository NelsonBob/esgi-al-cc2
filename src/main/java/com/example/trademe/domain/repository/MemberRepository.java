package com.example.trademe.domain.repository;

import com.example.trademe.domain.Member;
import com.example.trademe.domain.id.MemberId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, MemberId> {
    MemberId nextIdentity();

    Member findById(MemberId id);

    void add(Optional<Member> member);

    List<Member> findAll();

   // Member findByUsernameAndPassword(String username, String password);
}
