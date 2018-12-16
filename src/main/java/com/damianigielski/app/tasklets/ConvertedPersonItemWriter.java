package com.damianigielski.app.tasklets;

import com.damianigielski.app.entities.ConvertedPerson;
import com.damianigielski.app.repositories.ConvertedPersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@StepScope
@Component
public class ConvertedPersonItemWriter extends JpaItemWriter<ConvertedPerson> {

    private static final Logger log = LoggerFactory.getLogger(ConvertedPersonItemWriter.class);

    private ConvertedPersonRepository convertedPersonRepository;

    @Autowired
    public ConvertedPersonItemWriter(ConvertedPersonRepository convertedPersonRepository) {
        super();
        this.convertedPersonRepository = convertedPersonRepository;
    }

    @Override
    public void write(List<? extends ConvertedPerson> items) {
        log.info("========================================");
        log.info("WRITING CONVERTED PERSON OBJECTS");
        log.info("========================================");

        items.forEach(person -> log.info("Writing ConvertedPerson {}", person));

        convertedPersonRepository.saveAll(items);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        // Had to override this method so that it does not assert that EntityManagerFactory is not null.
    }
}
