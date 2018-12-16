package com.damianigielski.app.config;

import com.damianigielski.app.entities.ConvertedPerson;
import com.damianigielski.app.tasklets.ConvertedPersonItemWriter;
import com.damianigielski.app.tasklets.JobCompletionNotificationListener;
import com.damianigielski.app.entities.Person;
import com.damianigielski.app.tasklets.PersonItemProcessor;
import com.damianigielski.app.tasklets.PersonItemReader;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
@EnableJpaRepositories(basePackages = "com.damianigielski.app.repositories")
@ComponentScan
public class BatchConfiguration {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    public DataSource dataSource;

    @Autowired
    private PersonItemReader personItemReader;

    @Autowired
    private ConvertedPersonItemWriter convertedPersonItemWriter;

    @Autowired
    public PersonItemProcessor processor;


    @Bean
    public Job importUserJob(JobCompletionNotificationListener listener, Step step1) {
        return jobBuilderFactory.get("importUserJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1)
                .end()
                .build();
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .<Person, ConvertedPerson> chunk(10)
                .reader(personItemReader)
                .processor(processor)
                .writer(convertedPersonItemWriter)
                .build();
    }
}
