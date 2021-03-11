package com.codegym.duytan.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Component;

@Component
public class AuditEventListener{

    private static final Logger logger = LoggerFactory.getLogger(AuditEventListener.class);


}
