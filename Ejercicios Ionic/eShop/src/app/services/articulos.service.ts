import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';



@Injectable({
  providedIn: 'root'
})
export class ArticulosService {

  private url ='https://dummyjson.com/products'

  constructor(private http: HttpClient) { }


  get_articulos() {
    return this.http.get(this.url);
  }
}
