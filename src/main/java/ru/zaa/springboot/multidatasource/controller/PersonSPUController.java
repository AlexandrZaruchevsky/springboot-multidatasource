package ru.zaa.springboot.multidatasource.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.zaa.springboot.multidatasource.domain.firebird.PersonSPU;
import ru.zaa.springboot.multidatasource.repository.firebird.PersonSPURepo;

@RestController
@RequestMapping("getFIOFromSPU")
public class PersonSPUController {

    private final PersonSPURepo personSPURepo;

    public PersonSPUController(PersonSPURepo personSPURepo) {
        this.personSPURepo = personSPURepo;
    }

    @GetMapping
    public PersonSPU getFIOFromSPU(
            @RequestParam(required = false, defaultValue = "") String sn
    ){
        return personSPURepo.findBySn(sn);
    }

}
