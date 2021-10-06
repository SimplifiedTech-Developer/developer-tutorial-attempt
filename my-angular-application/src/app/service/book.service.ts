import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class BookService {
  books : any;
  constructor(private httpClient : HttpClient) {
  }

  getBooks(){
    return  this.httpClient.get("http://localhost:8080/v1/api/book");
  }
}
