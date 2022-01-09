package com.example.trademe.infrastructure;

import com.example.trademe.domain.Member;
import com.example.trademe.domain.exception.NoSuchElementException;
import com.example.trademe.domain.id.MemberId;
import com.example.trademe.domain.repository.MemberRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

public class InMemoryMemberRepository implements MemberRepository {
    private final AtomicInteger count = new AtomicInteger(0);

    private final Map<MemberId, Member> data = new ConcurrentHashMap<>();

    @Override
    public MemberId nextIdentity() { return new MemberId(count.incrementAndGet());}

    @Override
    public Member findById(MemberId memberId) {
        System.out.println("Recherche du membre dans : " + data + " avec l'id :" + memberId);
        final Member member = data.get(memberId);
        if(member == null) {
            throw NoSuchElementException.withId(memberId.getId());
        }
        return member;
    }

    @Override
    public boolean existsById(MemberId memberId) {
        return false;
    }

    @Override
    public void add(Optional<Member> member) {

    }


    public void add(Member member) {
        data.put(member.getId(), member);
    }

    @Override
    public List<Member> findAll() {
        return (List<Member>) data.values();
    }

    @Override
    public List<Member> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Member> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Member> findAllById(Iterable<MemberId> memberIds) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(MemberId memberId) {

    }

    @Override
    public void delete(Member entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends MemberId> memberIds) {

    }

    @Override
    public void deleteAll(Iterable<? extends Member> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Member> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Member> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Member> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Member> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Member> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<MemberId> memberIds) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Member getOne(MemberId memberId) {
        return null;
    }

    @Override
    public Member getById(MemberId memberId) {
        return null;
    }

    @Override
    public <S extends Member> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Member> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Member> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Member> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Member> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Member> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Member, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    public Member findByUsernameAndPassword(String username, String password) {
        return null;
    }
}
