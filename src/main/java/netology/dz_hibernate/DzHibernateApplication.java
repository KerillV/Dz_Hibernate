package netology.dz_hibernate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import netology.dz_hibernate.enums.Person;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class DzHibernateApplication implements CommandLineRunner {
    @PersistenceContext
    private EntityManager entityManager;

    public static void main(String[] args) {
        SpringApplication.run(DzHibernateApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        // создаем персону
//        Person person = Person.builder()
//                .name("Anna")
//                .surname("Any")
//                .age(22)
//                .cityOfLiving("Moscow")
//                .build();
//        entityManager.persist(person);

        // удаляем персону
//        var person = entityManager.find(Person.class, 5);
//        entityManager.remove(person);

//        var persons = entityManager.createQuery("select p from Person p").getResultList();
//        System.out.println(persons);

        // запрос персон по городу проживания
//        String city = "Moscow";
//        var personsCity = entityManager.createQuery(
//                "select p from Person p WHERE p.cityOfLiving = :city", Person.class);
//        personsCity.setParameter("city", city);
//        List<Person> personsInMoscow = personsCity.getResultList();
//                System.out.println(personsInMoscow);
    }
}
