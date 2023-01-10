import {Component, OnInit} from '@angular/core';
import {User} from '../../model/user';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  user: User = {
    "id":890,
    "name":"Tebatso",
    "email":"Tebatso191@gmail.com",
    "mobile":986235865
  }

  constructor() {
  }

  ngOnInit(): void {
  }

}
