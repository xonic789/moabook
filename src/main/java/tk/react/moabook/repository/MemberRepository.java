package tk.react.moabook.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import tk.react.moabook.domain.Member;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    public void save(Member member){
        em.persist(member);
    }

    public Member findOne(Long id){
        return em.find(Member.class, id);
    }
    

}
