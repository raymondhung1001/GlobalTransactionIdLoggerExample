package com.example.globaltransactionidloggerexample;

<<<<<<< HEAD
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

=======
>>>>>>> 8fddfdb (update)
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

<<<<<<< HEAD
import com.example.globaltransactionidloggerexample.service.ExampleService;
import com.example.globaltransactionidloggerexample.utils.CustomLogging.TransactionLogged;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

=======
>>>>>>> 8fddfdb (update)
@ViewScoped
@Named("exampleView")
public class ExampleView implements Serializable {
    
    //private final Logger logger = LogManager.getLogger(ExampleView.class);

    private static final long serialVersionUID = 5323090941381871734L;

<<<<<<< HEAD
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
=======
    private String message;

    @PostConstruct
    public void init() {
        message = "Hello, World!";
        System.out.println("ExampleView bean initialized with message: " + message);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
>>>>>>> 8fddfdb (update)

}
