package ru.zaa.springboot.multidatasource.repository.mysql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.zaa.springboot.multidatasource.domain.mysql.Person;

@Repository
public interface PersonRepo extends JpaRepository<Person, Long> {



}
