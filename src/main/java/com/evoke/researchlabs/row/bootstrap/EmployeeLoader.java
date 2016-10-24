package com.evoke.researchlabs.row.bootstrap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.evoke.researchlabs.row.domain.Employee;
import com.evoke.researchlabs.row.repositories.RestServiceCall;


@Component
public class EmployeeLoader implements ApplicationListener<ContextRefreshedEvent> {

    private RestServiceCall restServiceCall;

    private Logger logger = Logger.getLogger(EmployeeLoader.class);

    @Autowired
    public void setProductRepository(RestServiceCall restServiceCall) {
        this.restServiceCall = restServiceCall;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        Employee emp1 = new Employee();
        emp1.setEmailId("rakesh@gmail.com");
        emp1.setUserName("Rakesh");
        restServiceCall.postEntity(emp1);

        logger.info("Saved employee emp1 details");

        Employee emp2 = new Employee();
        emp2.setEmailId("grana@gmail.com");
        emp2.setUserName("Gaurav");
        restServiceCall.postEntity(emp2);

        
        logger.info("Saved employee emp1 details");

    }
}
