package netology.dz_hibernate.controller;

import netology.dz_hibernate.enums.Person;
import netology.dz_hibernate.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    // возвращаем список персон по указанному городу
    @GetMapping("/by-city")
    public List<Person> findByCityOfLiving(@RequestParam String city) {
        return personService.getPersonsByCity(city);
    }

    // возвращаем список персон по возрасту младше age
    @GetMapping("/younger-than-age")
    public List<Person> getYoungerThanAge(@RequestParam Integer age) {
        return personService.getPersonsByAgeLessThanOrderByAgeAsc(age);
    }

    // возвращаем список персон по имени и фамилии
    @GetMapping("/search-by-name-and-surname")
    public ResponseEntity<?> searchByNameAndSurname(
            @RequestParam(required = true) String name, // гарантирует, что оба параметра обязательны и должны присутствовать в запросе
            @RequestParam(required = true) String surname) {

        Optional<Person> foundPerson = personService.searchByNameAndSurname(name, surname);

        if (foundPerson.isPresent()) {
            /*Результат выполняется через ResponseEntity, что позволяет удобно управлять статусом ответа:
            - Если человек найден (Optional.isPresent()), отправляется успешный ответ с объектом.
            - Если не найден, возвращается статус notFound().*/
            return ResponseEntity.ok(foundPerson.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
