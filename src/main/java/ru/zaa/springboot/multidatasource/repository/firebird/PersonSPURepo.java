package ru.zaa.springboot.multidatasource.repository.firebird;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.zaa.springboot.multidatasource.domain.firebird.PersonSPU;

import java.util.List;

@Repository
public interface PersonSPURepo extends JpaRepository<PersonSPU, Long> {

    default List<PersonSPU> findByAll() {
        return null;
    }


    PersonSPU findBySn(String sn);

}
