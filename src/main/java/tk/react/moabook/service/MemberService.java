package tk.react.moabook.service;

import tk.react.moabook.domain.Member;

import java.util.List;

public interface MemberService {

    Member login(String email, String password);
    Long join(Member member);
    List<Member> findMembers();
    Member findOne(Long id);
    void updateProfile(Long id, Member member);

}
