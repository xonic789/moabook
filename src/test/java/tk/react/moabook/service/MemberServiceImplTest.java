package tk.react.moabook.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import tk.react.moabook.domain.Member;
import tk.react.moabook.domain.enums.Gender;
import tk.react.moabook.repository.MemberRepository;

import javax.persistence.EntityManager;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class MemberServiceImplTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;
    @Autowired EntityManager em;

    @Test
    public void createMember() throws Exception{
        //given
        Member member = new Member();


        //when
        Long id = memberService.join(member);
        Member login = memberService.login("xonic789@naver.com", "1234");

        //then
        assertEquals(member,memberRepository.findOne(id));
        assertEquals(member.getId(),login.getId());
    }
}