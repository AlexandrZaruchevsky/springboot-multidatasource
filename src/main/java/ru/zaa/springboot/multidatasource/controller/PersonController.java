package ru.zaa.springboot.multidatasource.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.zaa.springboot.multidatasource.domain.mysql.Person;
import ru.zaa.springboot.multidatasource.repository.mysql.PersonRepo;

import java.util.List;

@RestController
@RequestMapping("persons")
public class PersonController {

    private final PersonRepo personRepo;

    public PersonController(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    @GetMapping
    public List<Person> getPersons(){
//        personRepo.save(new Person("050910020"));

        return personRepo.findAll();
    }

}
