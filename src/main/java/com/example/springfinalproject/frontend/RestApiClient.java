package com.example.springfinalproject.frontend;

import com.example.springfinalproject.dto.InvoiceDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@AllArgsConstructor
@Service
public class RestApiClient {


    public void sendListProductHttpRequest() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getForObject("http://localhost:8080/api/invoices", String.class);

    }

}
