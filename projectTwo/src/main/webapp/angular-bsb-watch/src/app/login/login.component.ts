import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  private loginURL = '/login';

  onSubmit() {
    console.log("this works");
  } 

  loginImage:any = "assets\\images\\bb4.jpg";
  title = 'app';

  constructor(private http: HttpClient) { }



  ngOnInit() {
  }

}
