package com.pd.currency.exchange.service;

import com.pd.currency.exchange.entity.CurrencyExchange;
import com.pd.currency.exchange.repository.CurrencyExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService {

    private final Environment environment;

    private final CurrencyExchangeRepository currencyExchangeRepository;

    @Autowired
    CurrencyExchangeServiceImpl(CurrencyExchangeRepository currencyExchangeRepository, Environment environment) {
        this.currencyExchangeRepository = currencyExchangeRepository;
        this.environment = environment;
    }

    @Override
    public CurrencyExchange getCurrencyConversion(String from, String to) {
        CurrencyExchange currencyExchange = this.currencyExchangeRepository.findByFromAndTo(from, to);
        currencyExchange.setEnvironment(environment.getProperty("local.server.port"));
        return currencyExchange;
    }
}
