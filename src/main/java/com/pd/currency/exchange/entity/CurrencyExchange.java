package com.pd.currency.exchange.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "currency_exchange")
@Data
@NoArgsConstructor
public class CurrencyExchange {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "currency_from")
    private String from;

    @Column(name = "currency_to")
    private String to;

    @Column(name = "rate")
    private BigDecimal rate;

    @Transient
    private String environment;

}
