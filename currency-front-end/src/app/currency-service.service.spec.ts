import { TestBed } from '@angular/core/testing';

import { CurrencyConverterService } from './currency-converter.service';

describe('CurrencyServiceService', () => {
  let service: CurrencyConverterService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CurrencyConverterService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
