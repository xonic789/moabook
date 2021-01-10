package tk.react.moabook.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import tk.react.moabook.domain.Account;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class AccountRepository {

    private final EntityManager em;

    public void save(Account account){
        em.persist(account);
    }

    public Account findOne(Long id){
        return em.find(Account.class,id);
    }





}
