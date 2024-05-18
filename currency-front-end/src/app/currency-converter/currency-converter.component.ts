import { Component } from '@angular/core';
import {CurrencyConverterService} from "../currency-converter.service";

@Component({
  selector: 'app-currency-converter',
  templateUrl: './currency-converter.component.html',
  styleUrl: './currency-converter.component.css'
})
export class CurrencyConverterComponent {
  fromCurrency = '';
  toCurrency = '';
  amount = 1;
  result: number | null = null;

  constructor(private currencyConverterService: CurrencyConverterService) {
  }

  convertCurrency() {
    this.currencyConverterService.convert(this.fromCurrency.toLocaleUpperCase(), this.toCurrency.toLocaleUpperCase(), this.amount)
      .subscribe((data: number | null) => {
        this.result = data;
      });
  }
}
