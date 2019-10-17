import { Component, OnInit } from '@angular/core';
import { User } from "../user";
import { HttpClient } from '@angular/common/http';



@Component({
  selector: 'app-registration-user',
  templateUrl: './registration-user.component.html',
  styleUrls: ['./registration-user.component.css']
})
export class RegistrationUserComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }
   
  http: HttpClient;
  result: any;
  UrlEndpoint: string = "localhost:4200/register/new";

  submit(u: User) {
    this.http.post(this.UrlEndpoint, JSON.stringify(u)).subscribe(
      res => this.result = res)    
  }

}
