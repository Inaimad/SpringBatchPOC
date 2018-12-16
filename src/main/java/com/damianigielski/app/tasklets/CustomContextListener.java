package com.damianigielski.app.tasklets;

import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.listener.ExecutionContextPromotionListener;
import org.springframework.stereotype.Component;

@JobScope
@Component
public class CustomContextListener extends ExecutionContextPromotionListener {

    public CustomContextListener() {
        String[] keys = {"OK_PERSON_IDS"};
        this.setKeys(keys);
    }
}
