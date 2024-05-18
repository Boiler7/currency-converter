import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CurrencyConverterService {
  private apiUrl = 'http://localhost:8080/';

  constructor(private http: HttpClient) {
  }

  convert(from: string, to: string, amount: number): Observable<number> {
    const params = new HttpParams()
      .set('from', from)
      .set('to', to)
      .set('amount', amount.toString());

    return this.http.get<number>(this.apiUrl, {params});
  }
}
