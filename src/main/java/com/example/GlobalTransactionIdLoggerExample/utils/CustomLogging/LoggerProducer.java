package com.example.globaltransactionidloggerexample.utils.CustomLogging;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.enterprise.context.ApplicationScoped;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;

@ApplicationScoped
public class LoggerProducer implements Serializable {

    private static final long serialVersionUID = 8358142547583134132L;

    @Produces
    public Logger produceLogger(InjectionPoint injectionPoint) {
        Class<?> clazz = injectionPoint.getMember().getDeclaringClass();
        return LogManager.getLogger(clazz);
    }
}