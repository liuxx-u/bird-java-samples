package com.bird.samples.statemachine;

import com.bird.statemachine.StateProcessor;
import com.bird.statemachine.initialize.annotation.AnnotationStateMachineInitializer;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

    @Bean
    public AnnotationStateMachineInitializer annotationStateMachineInitializer(ObjectProvider<List<StateProcessor>> processors){
        return new AnnotationStateMachineInitializer(processors.getIfAvailable());
    }
}
