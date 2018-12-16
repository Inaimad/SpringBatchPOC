package com.damianigielski.app.tasklets;

import com.damianigielski.app.entities.Person;
import com.damianigielski.app.repositories.PersonRepository;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collections;
@StepScope
@Component
public class PersonItemReader extends RepositoryItemReader<Person> {

    private PersonRepository personRepository;

    @Autowired
    public PersonItemReader(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostConstruct
    private void initialize() {
        this.setRepository(personRepository);
        this.setPageSize(10);
        this.setMethodName("findAll");
        this.setSort(Collections.singletonMap("id", Sort.Direction.ASC));
    }

}
