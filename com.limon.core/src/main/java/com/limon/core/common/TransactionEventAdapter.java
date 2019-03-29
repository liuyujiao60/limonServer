package com.limon.core.common;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

public abstract class TransactionEventAdapter {

    public abstract void listenEvent(TransactionEvent transactionEvent);
}
