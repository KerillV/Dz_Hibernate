package netology.dz_hibernate.controller;

import netology.dz_hibernate.enums.Person;
import netology.dz_hibernate.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    // возвращаем список персон по указанному городу
    @GetMapping("/by-city")
    public List<Person> getPersonsByCity(@RequestParam String city) {
        return personService.getPersonsByCity(city);
    }

    @GetMapping("/")
    public String testEndpoint() {
        return "Тест пройден!";
    }
}
