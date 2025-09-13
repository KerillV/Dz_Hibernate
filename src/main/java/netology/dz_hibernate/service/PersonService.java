package netology.dz_hibernate.service;

import netology.dz_hibernate.enums.Person;
import netology.dz_hibernate.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository repository;

    @Autowired
    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public List<Person> getPersonsByCity(String city) {
        return repository.findByCityOfLiving(city);
    }

    public List<Person> getPersonsByAgeLessThanOrderByAgeAsc(Integer age) {
        return repository.findAllByAgeLessThanOrderByAgeAsc(age);
    }

    public Optional<Person> searchByNameAndSurname(String name, String surname) {
        return repository.findByNameAndSurnameQuery(name, surname);
    }
}
