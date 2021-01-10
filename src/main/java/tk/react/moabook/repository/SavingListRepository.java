package tk.react.moabook.repository;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import tk.react.moabook.domain.SavingList;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class SavingListRepository {

    private final EntityManager em;

    public void save(SavingList savingList){
        em.persist(savingList);
    }

    public SavingList findOne(Long id){
        return em.find(SavingList.class,id);
    }

    public List<SavingList> findAll(){
        return em.createQuery("select l from SavingList l", SavingList.class)
                .getResultList();
    }

}
