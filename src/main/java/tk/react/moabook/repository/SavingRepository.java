package tk.react.moabook.repository;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import tk.react.moabook.domain.Saving;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class SavingRepository {

    private final EntityManager em;

    public void save(Saving saving){
        em.persist(saving);
    }

    public Saving findOne(Long id){
        return em.find(Saving.class,id);
    }

    public List<Saving> findAll(){
        return em.createQuery("select s from Saving s",Saving.class)
                .getResultList();
    }

}
