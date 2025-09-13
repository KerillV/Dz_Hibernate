package netology.dz_hibernate.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import netology.dz_hibernate.enums.Person;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonRepository {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Метод выборки персон по заданному городу
     */
    @Transactional
    public List<Person> getPersonsByCity(String city) {
        var query = entityManager.createQuery(
                "SELECT p FROM Person p WHERE p.cityOfLiving = :city",
                Person.class
        );
        query.setParameter("city", city);
        return query.getResultList();
    }
}