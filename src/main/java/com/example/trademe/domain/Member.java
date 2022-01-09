package com.example.trademe.domain;

import com.example.trademe.domain.id.MemberId;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;
@Getter
@Setter
public class Member {
    private final MemberId id;
    private final String firstname;
    private final String lastname;
    private final String username;
    private String password;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(id, member.id) && Objects.equals(firstname, member.firstname) && Objects.equals(lastname, member.lastname) && Objects.equals(username, member.username) && Objects.equals(password, member.password) && Objects.equals(skills, member.skills) && Objects.equals(workplaces, member.workplaces) && Objects.equals(dailyrate, member.dailyrate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, username, password, skills, workplaces, dailyrate);
    }

    private List<String> skills;
    private List<String> workplaces;
    private Integer dailyrate;

    public Member(MemberId memberId, String firstname, String lastname, String username, String password) {
        this.id = memberId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
    }

    public static Member of(MemberId memberId, String firstname, String lastname, String username, String password){
        return new Member(memberId, firstname, lastname, username, password);
    }

    public void addSkill(String skill) { this.skills.add(skill);}
    public void addWorkplace(String workplace) { this.workplaces.add(workplace);}
    public void changePassword(String newPassword) { this.password = Objects.requireNonNull(newPassword);}
    public void changeDailyRate(Integer newDailyRate) { this.dailyrate = Objects.requireNonNull(newDailyRate);}


    @Override
    public String toString() {
        return "Member{" +
                "memberId=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", skills=" + skills +
                ", workplaces=" + workplaces +
                ", dailyrate=" + dailyrate +
                '}';
    }

    public MemberId getId() {
        return id;
    }
}
