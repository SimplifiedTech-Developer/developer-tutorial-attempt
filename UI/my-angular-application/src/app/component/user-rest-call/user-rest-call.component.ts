import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-user-rest-call',
  templateUrl: './user-rest-call.component.html',
  styleUrls: ['./user-rest-call.component.css']
})
export class UserRestCallComponent implements OnInit {

  constructor(private httpRestClient : HttpClient) { }

  ngOnInit(): void {
    let response = this.httpRestClient.get("https://jsonplaceholder.typicode.com/users");
    // console.log(response);
    response.subscribe((data) => console.log(data));
  }
}
