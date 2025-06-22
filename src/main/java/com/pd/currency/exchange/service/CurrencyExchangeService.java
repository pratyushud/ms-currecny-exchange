package com.pd.currency.exchange.service;

import com.pd.currency.exchange.entity.CurrencyExchange;

public interface CurrencyExchangeService {

    CurrencyExchange getCurrencyConversion(String from, String to);
}
