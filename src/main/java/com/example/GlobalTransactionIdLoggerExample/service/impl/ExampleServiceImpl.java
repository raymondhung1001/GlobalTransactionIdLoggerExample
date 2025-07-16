package com.example.globaltransactionidloggerexample.service.impl;

import com.example.globaltransactionidloggerexample.dao.ExampleDao;
import com.example.globaltransactionidloggerexample.service.ExampleService;
import com.example.globaltransactionidloggerexample.utils.CustomLogging.TransactionLogged;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class ExampleServiceImpl implements ExampleService {

    private final Logger logger = LogManager.getLogger(ExampleServiceImpl.class);

    @Inject
    private ExampleDao exampleDao;

    @Override
    @TransactionLogged
    public List<String> getExampleResult() {
        logger.info("ExampleServiceImpl returning examples");
        return exampleDao.getExampleResult();
    }

}
