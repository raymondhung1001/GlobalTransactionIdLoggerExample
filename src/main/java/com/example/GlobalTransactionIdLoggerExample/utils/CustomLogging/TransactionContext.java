package com.example.globaltransactionidloggerexample.utils.CustomLogging;

import java.io.Serializable;
import java.util.UUID;
import javax.enterprise.context.RequestScoped;

@RequestScoped
public class TransactionContext implements Serializable {

    private static final long serialVersionUID = 7095457921151398910L;

    private String transactionId;

    public String getCurrentTransactionId() {
        if (transactionId == null) {
            transactionId = generateTransactionId();
        }
        return transactionId;
    }

    private String generateTransactionId() {
        return UUID.randomUUID().toString();
    }
}