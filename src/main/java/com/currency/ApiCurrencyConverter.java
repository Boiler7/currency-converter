package com.currency;

import com.currency.model.ConverterResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Currency;
import java.util.Locale;

@RequiredArgsConstructor
@Service
public class ApiCurrencyConverter {
    private static final WebClient webClient = WebClient.builder().build();
    private final CurrencyProperties config;

    public double calculate(Currency from, Currency to, double amount) {
        var result = webClient.get()
                .uri(config.getUrl(), uri -> uri.queryParam("apikey", config.getApiKey())
                        .queryParam("base_currency", from.getCurrencyCode())
                        .queryParam("currencies", to.getCurrencyCode())
                        .build())
                .retrieve()
                .bodyToMono(ConverterResponse.class)
                .block();

        return Math.floor(result.getData().get(to.getCurrencyCode()).getValue() * amount * 100) / 100;
    }
}
