package com.example.springfinalproject.frontend;


import com.example.springfinalproject.entity.Invoice;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@Service
public class RestApiClient {


//    public ResponseEntity<Invoice[]> sendListProductHttpRequest() {
//        RestTemplate restTemplate = new RestTemplate();
//        System.out.println("1");
//        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
//        System.out.println("2");
//        ResponseEntity<Invoice[]> response = restTemplate.getForEntity("http://localhost:8080/api/invoices", Invoice[].class);
//        System.out.println("3");
//        Invoice[] invoices = response.getBody();
//        return ResponseEntity.ok(invoices);
//    }

    public List<Invoice> sendListProductHttpRequest() {
        RestTemplate restTemplate = new RestTemplate();
        Invoice[] response = restTemplate.getForObject("http://localhost:8080/api/invoices", Invoice[].class);
        return Arrays.asList(response);
    }
}
