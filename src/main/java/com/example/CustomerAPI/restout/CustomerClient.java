package com.example.CustomerAPI.restout;

import com.example.CustomerAPI.common.exception.CustomerException;
import com.example.CustomerAPI.vo.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerClient {

    private final String GET_CUSTOMER_URL = "http://spp.se/soap-api/GetCustomer";
    private final String CREATE_CUSTOMER_URL = "http://spp.se/soap-api/CreateCustomer";
    RestTemplate restTemplate;

    @Autowired
    public CustomerClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Customer getCustomer(String personOfficialId){

        return restTemplate.getForEntity(GET_CUSTOMER_URL, Customer.class, personOfficialId).getBody();
    }

    public ResponseEntity<Customer> createCustomer(Customer customer) throws CustomerException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Customer> httpEntity = new HttpEntity<>(customer, headers);

        return restTemplate.postForEntity(CREATE_CUSTOMER_URL, httpEntity, Customer.class);
    }
}
