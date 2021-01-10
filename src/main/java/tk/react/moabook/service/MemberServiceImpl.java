package tk.react.moabook.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.react.moabook.domain.Member;
import tk.react.moabook.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    /**
     * 회원 가입
     * @param member
     * @return member.id
     */
    @Override
    public Long join(Member member) {
        checkMemberEmail(member);
        memberRepository.save(member);
        return member.getId();
    }
    private void checkMemberEmail(Member member){
        //EXCEPTION
        List<Member> findMembers = memberRepository.findByEmail(member.getEmail());
        if(!findMembers.isEmpty()){
            throw new IllegalStateException("이미 존재하는 이메일 입니다.");
        }
    }

    /**
     * 모든 회원을 가져온다.
     * @return
     */
    @Override
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    /**
     * 해당 id에 맞는 회원 가져오기
     * @param id
     * @return
     */
    @Override
    public Member findOne(Long id) {
        return memberRepository.findOne(id);
    }

    /**
     * 패스워드, 닉네임 수정
     * @param id
     * @param member
     */
    @Override
    @Transactional
    public void updateProfile(Long id, Member member) {
        Member findMember = memberRepository.findOne(id);
        checkMemberNickName(member);
        findMember.editProfile(member);
    }
    private void checkMemberNickName(Member member){
        List<Member> findMembers = memberRepository.findByEmail(member.getNickName());
        if(!findMembers.isEmpty()){
            throw new IllegalStateException("이미 존재하는 닉네임 입니다.");
        }
    }


    @Override
    public Optional<List<Member>> login(String email, String password) {
        List<Member> members = memberRepository.findAll();

        return Optional.ofNullable(memberRepository.findAll());
    }





}
