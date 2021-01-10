package tk.react.moabook.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import tk.react.moabook.domain.Member;
import tk.react.moabook.repository.MemberRepository;

import javax.persistence.EntityManager;
import javax.xml.crypto.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
        Member member = new Member("이승우","xonic789@naver.com","1234","","","","xonic", LocalDate.of(1995,9,06),"M","");
        //when
        Long id = memberService.join(member);
        System.out.println(member);
        //then
        assertEquals(member,memberRepository.findOne(id));
    }
}