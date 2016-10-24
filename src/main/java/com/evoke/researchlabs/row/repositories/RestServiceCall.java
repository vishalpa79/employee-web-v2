package com.evoke.researchlabs.row.repositories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.evoke.researchlabs.row.domain.Employee;

import java.util.List;

/**
 * 
 * RestFulClient implements the functionality like a postman client, it uses rest template object which
 * going to consume the service on respective URI and return the object in the form of string
 * @author P A VISHAL
 * @version 1.0
 * 
 */
@Component
@PropertySource(value = {"classpath:application.properties"})
public class RestServiceCall {
	@Autowired
	private Environment env;

	private static final Logger logger = LoggerFactory.getLogger(RestServiceCall.class);

	private String postUrl;
	
	 @Autowired
	    private RestTemplate restTemplate;
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	/**
	 * function for consuming the employee services
	 * @param employeeBean
	 * @return
	 */
	public Employee postEntity(Employee employeeBean) {
		logger.info("Begin /POST request!");
		postUrl = env.getProperty("service.url1");
		Employee emp = null;
		try {
			 emp = restTemplate.postForObject(postUrl, employeeBean, Employee.class);
			logger.info("Response for Post Request: " + emp);
		} catch (Exception e) {
			emp = null;
			logger.error("Exception while consuming rest service" + e);
		}
		return emp;
	}
	
	/*public Employee getForObject(Employee employeeBean){
		logger.info("Begin /POST request!");
		postUrl = env.getProperty("service.url2");
		Employee employee=restTemplate.getForObject(postUrl,Employee.class);
		logger.info("Response for Post Request: " + employee);
		return employee;
	}*/
	
	public List<Employee> listAllUsers(){
        postUrl = env.getProperty("service.url2");
        RestTemplate restTemplate = new RestTemplate();
        List<Employee> usersMap = restTemplate.getForObject(postUrl, List.class);
        return usersMap;
        }   
	
	public Employee getEmployeeById(){
		 postUrl = env.getProperty("service.url3");
		 RestTemplate restTemplate = new RestTemplate();
		 Employee emp = restTemplate.getForObject(postUrl, Employee.class);
		 return emp;
	}
	
}


