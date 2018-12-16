package com.damianigielski.app.tasklets;

import com.damianigielski.app.entities.ConvertedPerson;
import com.damianigielski.app.entities.Person;
import com.damianigielski.app.repositories.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

    private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

    private final JdbcTemplate jdbcTemplate;
    private PersonRepository personRepository;

    @Autowired
    public JobCompletionNotificationListener(JdbcTemplate jdbcTemplate, PersonRepository personRepository) {
        this.personRepository = personRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
            log.info("========================================");
            log.info("UPDATING MIGRATION STATUS");
            log.info("========================================");

            ExecutionContext jobContext = jobExecution.getExecutionContext();
            List<Integer> lista = (List<Integer>) jobContext.get("OK_PERSON_IDS");
            lista.forEach(id -> log.info("ID that is going to get updated: {}", id));

            personRepository.updateMigrationStatus(lista);

            log.info("========================================");
            log.info("!!! JOB FINISHED !!! Verifying results...");
            log.info("========================================");

            jdbcTemplate.query("SELECT person_id, first_name, last_name FROM converted_people",
                    (rs, row) -> new ConvertedPerson(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3))
            ).forEach(person -> log.info("Found <" + person + "> in the database."));
        }
        log.info("========================================");
        log.info("Verifying PEOPLE...");
        log.info("========================================");

        jdbcTemplate.query("SELECT person_id, first_name, last_name, migration_status FROM people",
                (rs, row) -> new Person(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4))
        ).forEach(person -> log.info("Found <" + person + "> in the database."));
    }
}
