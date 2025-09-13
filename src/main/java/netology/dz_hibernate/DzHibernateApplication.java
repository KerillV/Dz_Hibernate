package netology.dz_hibernate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import netology.dz_hibernate.enums.Person;
import netology.dz_hibernate.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

import static ch.qos.logback.classic.spi.ThrowableProxyVO.build;
import static org.hibernate.internal.util.collections.ArrayHelper.forEach;

@SpringBootApplication
public class DzHibernateApplication implements CommandLineRunner {
    @Autowired
    private PersonRepository personRepository;

    public static void main(String[] args) {
        SpringApplication.run(DzHibernateApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        // выводим список персон
//        var person = personRepository.findAll();
//        person.forEach(System.out::println);

        // добавляем в таблицу персон
//        var persons = new ArrayList<Person>();
//        persons.add(Person.builder()
//                .name("Oly")
//                .surname("Olly")
//                .age(26)
//                .cityOfLiving("Voronezh").
//                build());
//
//        persons.add(Person.builder()
//                .name("Serzh")
//                .surname("Serr")
//                .age(28)
//                .cityOfLiving("Kaluga").
//                build());
//
//        personRepository.saveAll(persons);

//        personRepository.findAll(Sort.by(Sort.Direction.ASC, "age"))
//                .forEach(System.out::println);

    }
}
