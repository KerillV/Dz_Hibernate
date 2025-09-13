package netology.dz_hibernate.repository;

import netology.dz_hibernate.enums.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findByCityOfLiving(String city);

    // Получение всех записей младше указанного возраста, сортировка по возрасту
    List<Person> findAllByAgeLessThanOrderByAgeAsc(Integer age);

    // Получение записи по комбинации имени и фамилии (возвращает Optional)
    //Optional<Person> findByNameAndSurname(String name, String surname); // 1 вариант
    @Query(value = "SELECT p FROM Person p WHERE p.name = :name AND p.surname = :surname")
    Optional<Person> findByNameAndSurnameQuery(
            @Param("name") String name,
            @Param("surname") String surname
    );
}