package com.currency.config;

import com.currency.ApiCurrencyConverter;
import com.currency.CurrencyProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CurrencyConverterConfig {
    @Configuration
    @ConditionalOnProperty(name = "currency-converter.provider", havingValue = "currency")
    public static class ConverterConfiguration {
        @Bean
        public ApiCurrencyConverter currencyConverter(CurrencyProperties properties) {
            return new ApiCurrencyConverter(properties);
        }
    }

}
