package com.currency;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Currency;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class CurrencyConverterController {
    private final ApiCurrencyConverter currencyConverter;

    @GetMapping
    public double convert(@RequestParam Currency from,
                          @RequestParam Currency to,
                          @RequestParam double amount) {
        return currencyConverter.calculate(from, to, amount);
    }
}
