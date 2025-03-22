package com.demo.currencyConversionService;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Map;
import java.util.HashMap;

import java.util.logging.Logger;

@RestController
public class CurrencyConversionController {

    @Autowired
    private CurrencyExchangeServiceProxy proxy;

    //public Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());

    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity){

        /***
         *
         * using RestTemplate

        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("from",from);
        uriVariables.put("to",to);

        ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity
                ("http://localhost:8000/currency-exchange/from/{from}/to/{to}",CurrencyConversionBean.class,uriVariables);

        CurrencyConversionBean response = responseEntity.getBody();

        return new CurrencyConversionBean(response.getId(),from,to,response.getConversionMultiple(),quantity,
                quantity.multiply(response.getConversionMultiple()),response.getPort());
        */

        //using Feign Proxy
        CurrencyConversionBean response = proxy.retriveExchangeValue(from, to);

        return new
                CurrencyConversionBean(response.getId(),from,to,response.getConversionMultiple(),quantity,
                quantity.multiply(response.getConversionMultiple()),response.getPort());



    }



}
