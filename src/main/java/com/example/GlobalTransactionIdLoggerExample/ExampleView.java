package com.example.globaltransactionidloggerexample;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;


import com.example.globaltransactionidloggerexample.service.ExampleService;
import com.example.globaltransactionidloggerexample.utils.CustomLogging.TransactionLogged;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@ViewScoped
@Named("exampleView")
public class ExampleView implements Serializable {


    private static final long serialVersionUID = 5323090941381871734L;

    private final Logger logger = LogManager.getLogger(ExampleView.class);

    @Inject
    private ExampleService exampleService;

    private List<String> examples;

    @PostConstruct
    public void init() {
        examples = new ArrayList<>();
    }

    @TransactionLogged
    public void showExamples() {
        logger.info("Showing examples");
        examples = exampleService.getExampleResult();
    }

    public List<String> getExampleResult() { return examples; }

    public void setExampleResult(List<String> examples) { this.examples = examples; }

}
