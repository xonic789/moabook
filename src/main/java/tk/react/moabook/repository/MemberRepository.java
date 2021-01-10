package tk.react.moabook.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import tk.react.moabook.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;

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

    public List<Member> findAll(){
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    public List<Member> findByEmail(String email){
        return em.createQuery("select m from Member m where m.email = :email", Member.class)
                .setParameter("email",email)
                .getResultList();
    }

    public List<Member> findByNickName(String nickName){
        return em.createQuery("select m from Member m where m.nickName = :nickName", Member.class)
                .setParameter("nickName",nickName)
                .getResultList();
    }




}
