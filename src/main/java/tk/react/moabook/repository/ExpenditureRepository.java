package tk.react.moabook.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import tk.react.moabook.domain.Expenditure;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ExpenditureRepository {

    private final EntityManager em;

    public void save(Expenditure expenditure){
        em.persist(expenditure);
    }

    public Expenditure findOne(Long id){
        return em.find(Expenditure.class, id);
    }

    public List<Expenditure> findAll(){

        return em.createQuery("select e from Expenditure e",Expenditure.class)
                .getResultList();
    }
}
