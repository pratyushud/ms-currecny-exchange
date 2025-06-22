package com.pd.currency.exchange.controller;

import com.pd.currency.exchange.entity.CurrencyExchange;
import com.pd.currency.exchange.service.CurrencyExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/currency-exchange")
public class CurrencyExchangeController {
    CurrencyExchangeService currencyExchangeService;

    @Autowired
    CurrencyExchangeController(CurrencyExchangeService currencyExchangeService) {
        this.currencyExchangeService = currencyExchangeService;
    }


    @GetMapping("/from/{from}/to/{to}")
    public ResponseEntity getCurrencyExchange(@PathVariable String from, @PathVariable String to) {
        CurrencyExchange currencyExchange = currencyExchangeService.getCurrencyConversion(from, to);
        if (currencyExchange == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(currencyExchange);
        }
    }
}
