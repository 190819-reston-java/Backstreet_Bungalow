import { Component, OnInit } from '@angular/core';
import { User } from "../user";



@Component({
  selector: 'app-registration-user',
  templateUrl: './registration-user.component.html',
  styleUrls: ['./registration-user.component.css']
})
export class RegistrationUserComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  user: User;

  submit() {
   
  }

  save(user) {

  }
}
