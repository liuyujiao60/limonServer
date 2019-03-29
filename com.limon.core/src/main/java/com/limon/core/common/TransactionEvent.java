package com.limon.core.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.ApplicationEvent;

public class TransactionEvent extends ApplicationEvent {

    public TransactionEvent(Object source) {
        super(source);
    }
}
