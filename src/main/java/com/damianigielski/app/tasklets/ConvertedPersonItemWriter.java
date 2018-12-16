package com.damianigielski.app.tasklets;

import com.damianigielski.app.entities.ConvertedPerson;
import com.damianigielski.app.repositories.ConvertedPersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@StepScope
@Component
public class ConvertedPersonItemWriter extends JpaItemWriter<ConvertedPerson> {

    private static final Logger log = LoggerFactory.getLogger(ConvertedPersonItemWriter.class);

    private ConvertedPersonRepository convertedPersonRepository;
    private StepExecution stepExecution;

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

        log.info("Write successful!");

        ExecutionContext stepContext = this.stepExecution.getExecutionContext();

        if(stepContext.containsKey("OK_PERSON_IDS")) {
            List<Integer> lista = (List<Integer>) stepContext.get("OK_PERSON_IDS");
            lista.addAll(idsProcessedCorrectly(items));
            stepContext.put("OK_PERSON_IDS", lista);
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        // Had to override this method so that it does not assert that EntityManagerFactory is not null.
    }

    @BeforeStep
    public void saveStepExecution(StepExecution stepExecution) {
        this.stepExecution = stepExecution;
        stepExecution.getExecutionContext().put("OK_PERSON_IDS", new ArrayList<Integer>());
    }

    private List<Integer> idsProcessedCorrectly(List<? extends ConvertedPerson> list) {
        List<Integer> ids = new ArrayList<>(list.size());
        list.forEach(person -> ids.add(person.getPerson_id()));

        return ids;
    }
}
