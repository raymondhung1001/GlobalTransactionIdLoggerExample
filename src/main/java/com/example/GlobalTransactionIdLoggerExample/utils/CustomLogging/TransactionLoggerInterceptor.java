package com.example.globaltransactionidloggerexample.utils.CustomLogging;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

import java.io.Serializable;
import java.lang.reflect.Method;

@Interceptor
@TransactionLogged
public class TransactionLoggerInterceptor implements Serializable {

    private static final long serialVersionUID = -3185978069037471071L;

    @Inject
    private Logger logger;

    @Inject
    private TransactionContext transactionContext;

    @AroundInvoke
    public Object logMethodExecution(InvocationContext context) throws Exception {

        String transactionId = transactionContext.getCurrentTransactionId();

        ThreadContext.put("txId", transactionId);

        String methodName = context.getMethod().getDeclaringClass().getName() + "." + context.getMethod().getName();

        logger.info("Entering method: {}", methodName);
        long startTime = System.currentTimeMillis();

        try {
            return context.proceed();
        } catch (Throwable t) {
            throw t;
        } finally {
            long executionTime = System.currentTimeMillis() - startTime;
            logger.info("Exiting method: {} (execution time: {} ms)", methodName, executionTime);
        }
    }

}