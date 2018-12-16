package com.damianigielski.app.tasklets;

import com.damianigielski.app.entities.ConvertedPerson;
import com.damianigielski.app.entities.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@StepScope
@Component
public class PersonItemProcessor implements ItemProcessor<Person, ConvertedPerson> {


    private static final Logger log = LoggerFactory.getLogger(ItemProcessor.class);


    @Override
    public ConvertedPerson process(final Person person) throws Exception {
        final ConvertedPerson transformedPerson =
                new ConvertedPerson(person.getId(), person.getFirstName().toUpperCase(), person.getLastName().toUpperCase());

        log.info("Converting {} into {}", person, transformedPerson);

        return transformedPerson;
    }
}
