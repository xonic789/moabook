package tk.react.moabook.repository;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import tk.react.moabook.domain.Income;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class IncomeRepository {

    private final EntityManager em;

    public void save(Income income){
        em.persist(income);
    }

    public Income findOne(Long id){
        return em.find(Income.class, id);
    }

    public List<Income> findAll(){
        return em.createQuery("select i from Income i",Income.class)
                .getResultList();
    }


}
