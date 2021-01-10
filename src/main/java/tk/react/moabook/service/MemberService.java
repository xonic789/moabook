package tk.react.moabook.service;

import tk.react.moabook.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberService {

    Optional<List<Member>> login(String email, String password);
    Long join(Member member);
    List<Member> findMembers();
    Member findOne(Long id);
    void updateProfile(Long id, Member member);

}
