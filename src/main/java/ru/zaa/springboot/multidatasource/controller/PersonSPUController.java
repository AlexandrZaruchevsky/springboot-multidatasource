package ru.zaa.springboot.multidatasource.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.zaa.springboot.multidatasource.domain.firebird.PersonSPU;
import ru.zaa.springboot.multidatasource.domain.firebird.ViewPersonSPU;
import ru.zaa.springboot.multidatasource.exception.PersonNotFoundException;
import ru.zaa.springboot.multidatasource.repository.firebird.PersonSPURepo;

@RestController
@RequestMapping("getFIOFromSPU")
public class PersonSPUController {

    private final PersonSPURepo personSPURepo;

    public PersonSPUController(PersonSPURepo personSPURepo) {
        this.personSPURepo = personSPURepo;
    }

    @GetMapping("{sn}")
    @JsonView(ViewPersonSPU.ShortJson.class)
    public PersonSPU getFIOFromSPU(
            @PathVariable String sn
    ) {
        PersonSPU personSPU = personSPURepo.findBySn(sn);
        if (personSPU == null) throw new PersonNotFoundException();
        return personSPU != null ? personSPU.trim() : personSPU;
    }

}
