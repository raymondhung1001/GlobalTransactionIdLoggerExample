package com.example.globaltransactionidloggerexample.dao.impl;

import com.example.globaltransactionidloggerexample.dao.ExampleDao;
import com.example.globaltransactionidloggerexample.utils.CustomLogging.TransactionLogged;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class ExampleDaoImpl implements ExampleDao {

    private final Logger logger = LogManager.getLogger(ExampleDaoImpl.class);


    @Override
    @TransactionLogged
    public List<String> getExampleResult() {
        logger.info("ExampleDaoImpl returning examples");
        List<String> exampleResult = new ArrayList<String>();
        exampleResult.add("Example 1");
        exampleResult.add("Example 2");
        exampleResult.add("Example 3");
        exampleResult.add("Example 4");
        exampleResult.add("Example 5");
        return exampleResult;
    }

}
